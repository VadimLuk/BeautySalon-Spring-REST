package com.epam.beautysalonspring.service.impl;

import com.epam.beautysalonspring.dto.SalonServiceDto;
import com.epam.beautysalonspring.dto.UserDto;
import com.epam.beautysalonspring.dto.UserStaffDto;
import com.epam.beautysalonspring.exceptions.EntityNotFoundException;
import com.epam.beautysalonspring.mapper.SalonServiceMapper;
import com.epam.beautysalonspring.mapper.UserMapper;
import com.epam.beautysalonspring.model.SalonService;
import com.epam.beautysalonspring.model.User;
import com.epam.beautysalonspring.model.enums.Role;
import com.epam.beautysalonspring.repository.SalonServiceRepository;
import com.epam.beautysalonspring.repository.UserRepository;
import com.epam.beautysalonspring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final SalonServiceRepository salonServiceRepository;
    private final UserMapper userMapper;
    private final SalonServiceMapper salonServiceMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("Layer: {}, Creating User: {}", this.getClass().getSimpleName(), userDto);
        User user = userRepository.save(userMapper.userDtoToUser(userDto));
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto) throws EntityNotFoundException {
        log.info("Layer: {}, Updating User: {}", this.getClass().getSimpleName(), userDto);

        User user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        userMapper.updateUserFromUserDto(userDto, user);
        user = userRepository.save(user);

        return userMapper.userToUserDto(user);
    }

    @Override
    public Set<SalonServiceDto> getServicesProvidedByUser(Long userId) throws EntityNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        return salonServiceMapper.mapToSalonServiceDtoList(user.getSalonServices());
    }

    @Override
    public SalonServiceDto assignSalonServiceToUser(Long userId, Long serviceId) throws EntityNotFoundException {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        SalonService salonService = salonServiceRepository.findById(serviceId)
                .orElseThrow(() -> new EntityNotFoundException("Service not found"));

        user.getSalonServices().add(salonService);
        userRepository.save(user);
        return salonServiceMapper.mapToSalonServiceDto(salonService);
    }

    @Override
    public void unassignSalonServiceToUser(Long userId, Long serviceId) throws EntityNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        SalonService salonService = salonServiceRepository.findById(serviceId)
                .orElseThrow(() -> new EntityNotFoundException("Service not found"));

        user.getSalonServices().remove(salonService);
        userRepository.save(user);
    }

    @Override
    public List<UserStaffDto> getSalonStaff() {
        log.info("Layer: {}, Getting staff", this.getClass().getSimpleName());
        return userMapper.usersToUserStaffDto(userRepository.findByRole(Role.MASTER));
    }

    @Override
    public UserDto getUserById(Long userId) throws EntityNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        log.info("Layer: {}, Getting User by Id: {}", this.getClass().getSimpleName(), userId);

        return userMapper.userToUserDto(user);
    }
}
