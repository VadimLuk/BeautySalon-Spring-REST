package com.epam.beautysalonspring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SalonServiceDto {
    private Long id;
    private String name;
    private Integer price;
    private Long subcategoryId;
}
