package com.epam.beautysalonspring.dto;

import com.epam.beautysalonspring.dto.groups.OnCreate;
import com.epam.beautysalonspring.dto.groups.OnUpdate;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@Builder
public class AppointmentDto {

    @Null(groups = {OnCreate.class, OnUpdate.class})
    private Long id;

    @NotNull(groups = OnCreate.class)
    private Long salonServiceId;

    private String salonServiceName;

    @NotNull(groups = OnCreate.class)
    private Long masterId;

    private String masterName;

    @NotNull(groups = OnCreate.class)
    @Null(groups = OnUpdate.class)
    private Long clientId;

    private String clientFirstName;

    private String clientLastName;

    @NotNull(groups = OnCreate.class)
    private Integer cost;


    @NotNull(groups = OnCreate.class)
    @FutureOrPresent
    private LocalDateTime bookedDateTime;

    private String status;
}
