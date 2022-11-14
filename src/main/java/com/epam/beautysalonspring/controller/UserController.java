package com.epam.beautysalonspring.controller;

import com.epam.beautysalonspring.dto.UserDto;
import com.epam.beautysalonspring.dto.UserStaffDto;
import com.epam.beautysalonspring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping()
    public UserDto createUser(@RequestBody UserDto userDto) {
        log.info("Layer: {}, Creating User: {}", this.getClass().getSimpleName(), userDto);
        return userService.createUser(userDto);
    }

    //Authorized
    @PatchMapping("/{id}")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        log.info("Layer: {}, Updating User: {}", this.getClass().getSimpleName(), userDto);
        return userService.updateUser(userDto);
    }
    //Authorized
    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        log.info("Layer: {}, Getting User by Id: {}", this.getClass().getSimpleName(), id);
        return userService.getUserById(id);
    }

    //Public Guest's Get Request
    @GetMapping("/staff")
    public List<UserStaffDto> getStaffUsers() {
        log.info("Layer: {}, Getting salon staff", this.getClass().getSimpleName());
        return userService.getStaffUsers();
    }

}
