package com.epam.beautysalonspring.controller;

import com.epam.beautysalonspring.dto.SalonServiceDto;
import com.epam.beautysalonspring.dto.UserDto;
import com.epam.beautysalonspring.dto.UserStaffDto;
import com.epam.beautysalonspring.dto.groups.OnCreate;
import com.epam.beautysalonspring.dto.groups.OnUpdate;
import com.epam.beautysalonspring.exceptions.EntityNotFoundException;
import com.epam.beautysalonspring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody @Validated(OnCreate.class) UserDto userDto) {
        log.info("Layer: {}, Creating User: {}", this.getClass().getSimpleName(), userDto);
        return userService.createUser(userDto);
    }

    //Authorized
    @PatchMapping("/{userId}")
    public UserDto updateUser(@RequestBody @Validated(OnUpdate.class) UserDto userDto) throws EntityNotFoundException {
        log.info("Layer: {}, Updating User: {}", this.getClass().getSimpleName(), userDto);
        return userService.updateUser(userDto);
    }

    //Authorized
    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable Long userId) throws EntityNotFoundException {
        log.info("Layer: {}, Getting User by Id: {}", this.getClass().getSimpleName(), userId);
        return userService.getUserById(userId);
    }

    @GetMapping("/{userId}/provided-services")
    public Set<SalonServiceDto> getServicesProvidedByUser(@PathVariable Long userId) throws EntityNotFoundException {
        return userService.getServicesProvidedByUser(userId);
    }


    @PutMapping("/{userId}/provided-services/{serviceId}")
    public SalonServiceDto assignSalonServiceForUser(@PathVariable Long userId, @PathVariable Long serviceId) throws EntityNotFoundException {
        //TODO Maybe realize PUT /{userId}/provided-services with Set<SalonServiceDto> assigning all
        return userService.assignSalonServiceToUser(userId, serviceId);
    }

    @DeleteMapping("/{userId}/provided-services/{serviceId}")
    public ResponseEntity<Void> unassignSalonServiceForUser(@PathVariable Long userId, @PathVariable Long serviceId) throws EntityNotFoundException {
        //TODO Maybe realize DELETE /{userId}/provided-services with Set<SalonServiceDto> unassigning all
        userService.unassignSalonServiceToUser(userId, serviceId);
        return ResponseEntity.noContent().build();
    }

    //Public Guest's Get Request
    @GetMapping("/staff")
    public List<UserStaffDto> getSalonStaff() {
        log.info("Layer: {}, Getting salon staff", this.getClass().getSimpleName());
        return userService.getSalonStaff();
    }

}
