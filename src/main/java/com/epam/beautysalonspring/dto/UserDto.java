package com.epam.beautysalonspring.dto;

import com.epam.beautysalonspring.validation.annotations.PhoneNumber;
import com.epam.beautysalonspring.dto.groups.OnCreate;
import com.epam.beautysalonspring.dto.groups.OnUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Null(groups = OnCreate.class)
    @NotNull(groups = OnUpdate.class)
    private Long id;

    @NotNull(groups = OnCreate.class)
    @Email
    private String email;

    @NotBlank(groups = OnCreate.class)
    @Size(min = 6, max = 30)
    private String password;

    private String role;

    @NotBlank(groups = OnCreate.class)
    @Size(min = 2, max = 20)
    private String firstName;

    @NotBlank(groups = OnCreate.class)
    @Size(min = 2, max = 30)
    private String lastName;

    @Positive
    private Double rating;

    @Size(max = 255)
    private String description;

    @NotBlank(groups = OnCreate.class)
    @PhoneNumber
    private String phoneNumber;

//    @Null(groups = OnCreate.class)
    private String userStatus;
}
