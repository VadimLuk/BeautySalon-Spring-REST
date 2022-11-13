package com.epam.beautysalonspring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Long id;
    private String email;
    private String password;
    private String repeatPassword;
    private String role;
    private String firstName;
    private String lastName;
    private Double rating;
    private String description;
    private String phoneNumber;
    private String userStatus;
}
