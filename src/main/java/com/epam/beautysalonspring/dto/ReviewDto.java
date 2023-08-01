package com.epam.beautysalonspring.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReviewDto {
    private Long id;
    private Long clientId;
    private String description;
    private LocalDateTime reviewDateTime;
}
