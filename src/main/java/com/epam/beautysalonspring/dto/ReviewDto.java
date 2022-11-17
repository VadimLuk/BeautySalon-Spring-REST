package com.epam.beautysalonspring.dto;

import com.epam.beautysalonspring.dto.groups.OnCreate;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@Builder
public class ReviewDto {

    @Null(groups = OnCreate.class)
    private Long id;

    @NotNull(groups = OnCreate.class)
    private Long clientId;

    @NotBlank(groups = OnCreate.class)
    @Size(min = 10, max = 255)
    private String description;

    @Null(groups = OnCreate.class)
    private LocalDateTime reviewDateTime;
}
