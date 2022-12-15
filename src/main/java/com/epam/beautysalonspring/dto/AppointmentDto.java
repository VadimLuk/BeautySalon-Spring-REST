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

    @Null(groups = OnCreate.class)
    @NotNull(groups = OnUpdate.class)
    private Long id;

    @NotNull(groups = OnCreate.class)
    private Long salonServiceId;

    @NotNull(groups = OnCreate.class)
    private Long masterId;

    @NotNull(groups = OnCreate.class)
    @Null(groups = OnUpdate.class)
    private Long clientId;

    @NotNull(groups = OnCreate.class)
    private Integer cost;

    @FutureOrPresent
    @NotNull(groups = OnCreate.class)
    private LocalDateTime bookedDateTime;

    private String status;
}
