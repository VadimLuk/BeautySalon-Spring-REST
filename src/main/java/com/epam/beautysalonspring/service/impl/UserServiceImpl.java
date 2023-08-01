package com.epam.beautysalonspring.service.impl;

import com.epam.beautysalonspring.dto.UserDto;
import com.epam.beautysalonspring.dto.UserStaffDto;
import com.epam.beautysalonspring.mapper.UserMapper;
import com.epam.beautysalonspring.model.User;
import com.epam.beautysalonspring.model.enums.Role;
import com.epam.beautysalonspring.repository.UserRepository;
import com.epam.beautysalonspring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("Layer: {}, Creating User: {}", this.getClass().getSimpleName(), userDto);
        User user = userRepository.create(userMapper.userDtoToUser(userDto));
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        log.info("Layer: {}, Updating User: {}", this.getClass().getSimpleName(), userDto);
        User user = userRepository.update(userMapper.userDtoToUser(userDto));
        return userMapper.userToUserDto(user);
    }

    @Override
    public List<UserStaffDto> getStaffUsers() {
        log.info("Layer: {}, Getting staff", this.getClass().getSimpleName());
        return userMapper.usersToUserStaffDto(userRepository.findByRole(Role.MASTER));
    }

    @Override
    public UserDto getUserById(Long userId) {
        log.info("Layer: {}, Getting User by Id: {}", this.getClass().getSimpleName(), userId);
        return userMapper.userToUserDto(userRepository.findById(userId));
    }
}
