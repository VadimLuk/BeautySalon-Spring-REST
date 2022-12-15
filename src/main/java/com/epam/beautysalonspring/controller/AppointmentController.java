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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


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
    public AppointmentDto getAppointment(@PathVariable Long appointmentId) throws EntityNotFoundException {
        log.info("Layer: {}, Getting Appointment with Id: {}", this.getClass().getSimpleName(), appointmentId);

        return appointmentService.findAppointmentById(appointmentId);
    }

    //appointments/filter?status=new&dateFrom=2022-12-14T00:00&dateTo=2022-12-14T23:59&sortBy=bookedDateTime&sortDir=asc
    @GetMapping()
    public Page<AppointmentDto> getAppointmentsPaginatedAndFiltered(@PathVariable Long userId,
                                                                    @RequestParam AppointmentStatus status,
                                                                    @RequestParam
                                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                                    LocalDateTime dateFrom,
                                                                    @RequestParam
                                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                                    LocalDateTime dateTo,
                                                                    @RequestParam(defaultValue = "0") Integer page,
                                                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(required = false, defaultValue = "bookedDateTime") String sortBy,
                                                                    @RequestParam(required = false, defaultValue = "asc") String sortDir) throws EntityNotFoundException {

        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.fromString(sortDir), sortBy));
        return appointmentService.findAppointmentsByUserFilteredAndPaginated(userId, status, dateFrom, dateTo, pageRequest);
    }
}
