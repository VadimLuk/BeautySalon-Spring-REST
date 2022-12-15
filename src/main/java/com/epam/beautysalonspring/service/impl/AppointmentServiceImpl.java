package com.epam.beautysalonspring.service.impl;

import com.epam.beautysalonspring.dto.AppointmentDto;
import com.epam.beautysalonspring.exceptions.EntityNotFoundException;
import com.epam.beautysalonspring.mapper.AppointmentMapper;
import com.epam.beautysalonspring.model.Appointment;
import com.epam.beautysalonspring.model.User;
import com.epam.beautysalonspring.model.enums.AppointmentStatus;
import com.epam.beautysalonspring.model.enums.Role;
import com.epam.beautysalonspring.repository.AppointmentRepository;
import com.epam.beautysalonspring.repository.UserRepository;
import com.epam.beautysalonspring.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final UserRepository userRepository;
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    @Override
    public AppointmentDto bookAppointment(AppointmentDto appointmentDto) {
        log.info("Layer: {}, Booking Appointment: {}", this.getClass().getSimpleName(), appointmentDto);

        Appointment appointment = appointmentRepository.save(appointmentMapper.mapToAppointment(appointmentDto));
        return appointmentMapper.mapToAppointmentDto(appointment);
    }

    @Override
    public AppointmentDto updateAppointment(AppointmentDto appointmentDto) {
        log.info("Layer: {}, Updating Appointment: {}", this.getClass().getSimpleName(), appointmentDto);

        Appointment appointment = appointmentRepository.save(appointmentMapper.mapToAppointment(appointmentDto));
        return appointmentMapper.mapToAppointmentDto(appointment);
    }


    @Override
    public AppointmentDto findAppointmentById(Long appointmentId) throws EntityNotFoundException {
        log.info("Layer: {}, Getting Appointment with Id: {}", this.getClass().getSimpleName(), appointmentId);

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found"));
        return appointmentMapper.mapToAppointmentDto(appointment);
    }

    @Override
    public Page<AppointmentDto> findAppointmentsByUserFilteredAndPaginated(Long userId,
                                                                           AppointmentStatus status,
                                                                           LocalDateTime bookedDateTimeStart,
                                                                           LocalDateTime bookedDateTimeEnd,
                                                                           Pageable pageable) throws EntityNotFoundException {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        if (user.getRole() == Role.CLIENT) {
            return appointmentMapper.mapToAppointmentDtoPage(
                    appointmentRepository.findByMasterOrClientAndStatusAndBookedDateTimeBetween
                            (user, status, bookedDateTimeStart, bookedDateTimeEnd, pageable));
        }

        if (user.getRole() == Role.MASTER) {
            return appointmentMapper.mapToAppointmentDtoPage(
                    appointmentRepository.findByMasterOrClientAndStatusAndBookedDateTimeBetween
                            (user, status, bookedDateTimeStart, bookedDateTimeEnd, pageable));
        }

        if (user.getRole() == Role.ADMIN) {
            return appointmentMapper.mapToAppointmentDtoPage(
                    appointmentRepository.findByStatusAndBookedDateTimeBetween(status, bookedDateTimeStart, bookedDateTimeEnd, pageable));
        } else {
            throw new IllegalArgumentException();
        }
    }

}
