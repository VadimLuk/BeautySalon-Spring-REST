package com.epam.beautysalonspring.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Subcategory {
    private Long id;
    private String name;
    private Long categoryId;
    private List<SalonService> salonServices;
}
