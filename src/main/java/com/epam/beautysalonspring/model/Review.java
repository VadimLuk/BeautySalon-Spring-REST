package com.epam.beautysalonspring.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Review {
    private Long id;
    private User client;
    private String description;
    private LocalDateTime reviewDateTime;
}
