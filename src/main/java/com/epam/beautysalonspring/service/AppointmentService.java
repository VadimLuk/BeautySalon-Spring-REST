package com.epam.beautysalonspring.service;

import com.epam.beautysalonspring.dto.AppointmentDto;
import com.epam.beautysalonspring.exceptions.EntityNotFoundException;
import com.epam.beautysalonspring.model.enums.AppointmentStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface AppointmentService {
    AppointmentDto bookAppointment(AppointmentDto appointmentDto);

    AppointmentDto updateAppointment(AppointmentDto appointmentDto);

    AppointmentDto findAppointmentById(Long appointmentId) throws EntityNotFoundException;

    Page<AppointmentDto> findAppointmentsByUserFilteredAndPaginated(Long userId,
                                                                    AppointmentStatus status,
                                                                    LocalDateTime bookedDateTimeStart,
                                                                    LocalDateTime bookedDateTimeEnd,
                                                                    Pageable pageable) throws EntityNotFoundException;
}
