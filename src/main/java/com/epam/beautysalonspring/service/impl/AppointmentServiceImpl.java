package com.epam.beautysalonspring.service.impl;

import com.epam.beautysalonspring.dto.AppointmentDto;
import com.epam.beautysalonspring.mapper.AppointmentMapper;
import com.epam.beautysalonspring.model.Appointment;
import com.epam.beautysalonspring.model.User;
import com.epam.beautysalonspring.model.enums.Role;
import com.epam.beautysalonspring.repository.AppointmentRepository;
import com.epam.beautysalonspring.repository.UserRepository;
import com.epam.beautysalonspring.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Appointment appointment = appointmentRepository.create(appointmentMapper.mapToAppointment(appointmentDto));
        return appointmentMapper.mapToAppointmentDto(appointment);
    }

    @Override
    public AppointmentDto updateAppointment(AppointmentDto appointmentDto) {
        log.info("Layer: {}, Updating Appointment: {}", this.getClass().getSimpleName(), appointmentDto);
        Appointment appointment = appointmentRepository.update(appointmentMapper.mapToAppointment(appointmentDto));
        return appointmentMapper.mapToAppointmentDto(appointment);
    }

    @Override
    public List<AppointmentDto> findAppointmentsByUser(Long userId) {
        log.info("Layer: {}, Getting All Appointments for User with Id: {}", this.getClass().getSimpleName(), userId);
        User user = userRepository.findById(userId);
        if (user.getRole() == Role.ADMIN) {
            return appointmentMapper.mapToAppointmentDtoList(appointmentRepository.findAll());
        } else {
            return appointmentMapper.mapToAppointmentDtoList(appointmentRepository.findByClientOrMaster(userId));
        }
    }
}
