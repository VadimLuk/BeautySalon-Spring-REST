package com.epam.beautysalonspring.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AppointmentDto {
    private Long id;
    private Long salonServiceId;
    private Long masterId;
    private Long clientId;
    private Integer cost;
    private LocalDateTime bookedDateTime;
    private String status;
}
