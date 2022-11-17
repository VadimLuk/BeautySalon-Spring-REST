package com.epam.beautysalonspring.controller;

import com.epam.beautysalonspring.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequiredArgsConstructor
@RequestMapping("/template/users")
public class RestTemplateService {

    private final String URI = "http://localhost:8080/users/";
    private final RestTemplate restTemplate;


    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        HttpEntity<UserDto> entity = new HttpEntity<>(userDto);
        return restTemplate.postForEntity(URI, entity, UserDto.class);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Long id) {
        HttpEntity<UserDto> entity = new HttpEntity<>(userDto);
        return restTemplate.exchange(URI + id, HttpMethod.PATCH, entity, UserDto.class);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String id) {
        return restTemplate.getForEntity(URI + id, UserDto.class);
    }

}
