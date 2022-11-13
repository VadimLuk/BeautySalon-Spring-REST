package com.epam.beautysalonspring.repository.impl;

import com.epam.beautysalonspring.model.Appointment;
import com.epam.beautysalonspring.model.enums.AppointmentStatus;
import com.epam.beautysalonspring.repository.AppointmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository {

    private static HashMap<Long, Appointment> appointments = new HashMap<>();
    private Long entityId = 0L;


    @Override
    public Appointment findById(Long id) {
        log.info("Layer: {}, Getting Appointment by Id: {}", this.getClass().getSimpleName(), id);
        return appointments.get(id);
    }

    @Override
    public List<Appointment> findByStatus(AppointmentStatus status) {
        log.info("Layer: {}, Getting All Appointments with status: {}", this.getClass().getSimpleName(), status);
        return appointments.values().stream()
                .filter(appointment -> appointment.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    @Override
    public Appointment update(Appointment appointment) {
        log.info("Layer: {}, Updating Appointment: {}", this.getClass().getSimpleName(), appointment);
        appointments.put(appointment.getId(), appointment);
        return appointments.get(appointment.getId());
    }

    @Override
    public Appointment create(Appointment appointment) {
        log.info("Layer: {}, Creating Appointment: {}", this.getClass().getSimpleName(), appointment);
        appointment.setId(entityId++);
        appointments.put(appointment.getId(), appointment);
        return appointments.get(appointment.getId());
    }

    @Override
    public List<Appointment> findAll() {
        log.info("Layer: {}, Getting All Appointments for Admin User", this.getClass().getSimpleName());
        return new ArrayList<>(appointments.values());
    }

    @Override
    public List<Appointment> findByClientOrMaster(Long userId) {
        log.info("Layer: {}, Getting All Appointments for User with Id: {}", this.getClass().getSimpleName(), userId);
        return appointments.values().stream()
                .filter(appointment ->
                        appointment.getMaster().getId().equals(userId)
                                ||
                                appointment.getClient().getId().equals(userId))
                .collect(Collectors.toList());
    }
}
