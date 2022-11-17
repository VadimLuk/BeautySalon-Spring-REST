package com.epam.beautysalonspring.dto;

import com.epam.beautysalonspring.dto.groups.OnCreate;
import com.epam.beautysalonspring.dto.groups.OnUpdate;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@Builder
public class SalonServiceDto {

    @Null(groups = OnCreate.class)
    @NotNull(groups = OnUpdate.class)
    private Long id;

    @NotBlank(groups = OnCreate.class)
    @Size(min = 3, max = 40)
    private String name;

    @NotNull(groups = OnCreate.class)
    @Positive
    private Integer price;

    private Long subcategoryId;
}
