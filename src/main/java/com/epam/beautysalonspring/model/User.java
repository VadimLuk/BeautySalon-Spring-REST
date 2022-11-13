package com.epam.beautysalonspring.model;

import com.epam.beautysalonspring.model.enums.Role;
import com.epam.beautysalonspring.model.enums.UserStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Long id;
    private String email;
    private String password;
    private Role role;
    private String firstName;
    private String lastName;
    private Double rating;
    private String description;
    private String phoneNumber;
    private UserStatus userStatus;
}
