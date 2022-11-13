package com.epam.beautysalonspring.repository;

import com.epam.beautysalonspring.model.Appointment;
import com.epam.beautysalonspring.model.enums.AppointmentStatus;

import java.util.List;

public interface AppointmentRepository {
    Appointment findById(Long id);

    List<Appointment> findByStatus(AppointmentStatus status);

    Appointment update(Appointment appointment);

    Appointment create(Appointment appointment);

    List<Appointment> findAll();

    List<Appointment> findByClientOrMaster(Long userId);
}
