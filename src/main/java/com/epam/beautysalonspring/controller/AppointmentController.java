package com.epam.beautysalonspring.controller;

import com.epam.beautysalonspring.dto.AppointmentDto;
import com.epam.beautysalonspring.dto.groups.OnCreate;
import com.epam.beautysalonspring.dto.groups.OnUpdate;
import com.epam.beautysalonspring.exceptions.EntityNotFoundException;
import com.epam.beautysalonspring.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users/{userId}/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;


    @PostMapping
    public AppointmentDto bookAppointment(@RequestBody @Validated(OnCreate.class) AppointmentDto appointmentDto) {
        log.info("Layer: {}, Booking Appointment: {}", this.getClass().getSimpleName(), appointmentDto);
        return appointmentService.bookAppointment(appointmentDto);
    }

    @PatchMapping("/{appointmentId}")
    public AppointmentDto updateAppointment(@RequestBody @Validated(OnUpdate.class) AppointmentDto appointmentDto) {
        log.info("Layer: {}, Updating Appointment: {}", this.getClass().getSimpleName(), appointmentDto);
        return appointmentService.updateAppointment(appointmentDto);
    }

    @GetMapping("/{appointmentId}")
    public AppointmentDto getAppointment(@PathVariable Long appointmentId) {
        log.info("Layer: {}, Getting Appointment with Id: {}", this.getClass().getSimpleName(), appointmentId);
        return appointmentService.findAppointmentById(appointmentId);
    }
    @GetMapping
    public List<AppointmentDto> getAppointments(@PathVariable Long userId) throws EntityNotFoundException {
        log.info("Layer: {}, Getting All Appointments for User with Id: {}", this.getClass().getSimpleName(), userId);
        return appointmentService.findAppointmentsByUser(userId);
    }


}
