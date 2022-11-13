package com.epam.beautysalonspring.model;

import com.epam.beautysalonspring.model.enums.AppointmentStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Appointment {
    private Long id;
    private SalonService salonService;
    private User master;
    private User client;
    private Integer cost;
    private LocalDateTime bookedDateTime;
    private AppointmentStatus status;
}
