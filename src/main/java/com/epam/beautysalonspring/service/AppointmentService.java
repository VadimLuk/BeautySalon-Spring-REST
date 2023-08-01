package com.epam.beautysalonspring.service;

import com.epam.beautysalonspring.dto.AppointmentDto;
import com.epam.beautysalonspring.exceptions.EntityNotFoundException;

import java.util.List;

public interface AppointmentService {
    AppointmentDto bookAppointment(AppointmentDto appointmentDto);

    AppointmentDto updateAppointment(AppointmentDto appointmentDto);

    List<AppointmentDto> findAppointmentsByUser(Long userId) throws EntityNotFoundException;

    AppointmentDto findAppointmentById(Long appointmentId);
}
