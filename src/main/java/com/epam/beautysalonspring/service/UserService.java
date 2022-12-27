package com.epam.beautysalonspring.service;

import com.epam.beautysalonspring.dto.SalonServiceDto;
import com.epam.beautysalonspring.dto.UserDto;
import com.epam.beautysalonspring.dto.UserStaffDto;
import com.epam.beautysalonspring.exceptions.EntityNotFoundException;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<UserStaffDto> getSalonStaff();

    UserDto getUserById(Long userId) throws EntityNotFoundException;

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto) throws EntityNotFoundException;

    Set<SalonServiceDto> getServicesProvidedByUser(Long id) throws EntityNotFoundException;

    SalonServiceDto assignSalonServiceToUser(Long userId, Long serviceId) throws EntityNotFoundException;

    void unassignSalonServiceToUser(Long userId, Long serviceId) throws EntityNotFoundException;
}
