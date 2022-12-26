package com.epam.beautysalonspring.controller;

import com.epam.beautysalonspring.dto.AppointmentDto;
import com.epam.beautysalonspring.dto.groups.OnCreate;
import com.epam.beautysalonspring.dto.groups.OnUpdate;
import com.epam.beautysalonspring.exceptions.EntityNotFoundException;
import com.epam.beautysalonspring.model.enums.AppointmentStatus;
import com.epam.beautysalonspring.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@Slf4j
@RestController
@RequestMapping("/users/{userId}/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentDto bookAppointment(@RequestBody @Validated(OnCreate.class) AppointmentDto appointmentDto) {
        log.info("Layer: {}, Booking Appointment: {}", this.getClass().getSimpleName(), appointmentDto);

        return appointmentService.bookAppointment(appointmentDto);
    }

    @PatchMapping("/{appointmentId}")
    public AppointmentDto updateAppointment(@PathVariable Long appointmentId,
                                            @RequestBody @Validated(OnUpdate.class) AppointmentDto appointmentDto) throws EntityNotFoundException {
        log.info("Layer: {}, Updating Appointment: {}", this.getClass().getSimpleName(), appointmentDto);
        return appointmentService.updateAppointment(appointmentId, appointmentDto);
    }

    @GetMapping("/{appointmentId}")
    public AppointmentDto getAppointment(@PathVariable Long appointmentId) throws EntityNotFoundException {
        log.info("Layer: {}, Getting Appointment with Id: {}", this.getClass().getSimpleName(), appointmentId);

        return appointmentService.findAppointmentById(appointmentId);
    }

    //appointments/?status=new&dateFrom=2022-12-14&dateTo=2022-12-30&number=0&size=1&sort=id,desc
    @GetMapping()
    public Page<AppointmentDto> getAppointmentsPaginatedAndFiltered(@PathVariable Long userId,
                                                                    @RequestParam(required = false) AppointmentStatus status,
                                                                    @RequestParam
                                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                    LocalDate dateFrom,
                                                                    @RequestParam
                                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                    LocalDate dateTo,
                                                                    Pageable pageable) throws EntityNotFoundException {
        return appointmentService.findAppointmentsByUserFilteredAndPaginated(userId, status, dateFrom, dateTo, pageable);
    }
}
