package com.epam.beautysalonspring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserStaffDto {
    private String firstName;
    private Double rating;
    private String description;
}
