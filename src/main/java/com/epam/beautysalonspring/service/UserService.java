package com.epam.beautysalonspring.service;

import com.epam.beautysalonspring.dto.UserDto;
import com.epam.beautysalonspring.dto.UserStaffDto;

import java.util.List;

public interface UserService {
    List<UserStaffDto> getStaffUsers();
    UserDto getUserById(Long userId);
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);

}
