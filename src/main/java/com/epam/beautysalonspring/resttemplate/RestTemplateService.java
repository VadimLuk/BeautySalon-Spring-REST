package com.epam.beautysalonspring.resttemplate;

import com.epam.beautysalonspring.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/template")
public class RestTemplateService {

    private final String URI = "http://localhost:8080/users/";
    private final RestTemplate restTemplate;


    public ResponseEntity<UserDto> createUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept((List.of(MediaType.APPLICATION_JSON)));
        headers.setAcceptPatch(List.of(MediaType.ALL));
        HttpEntity<UserDto> entity = new HttpEntity<>(UserDto.builder()
                .email("johndoe@gmail.com")
                .password("password")
                .role("client")
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("380667894568")
                .build(), headers);
        return restTemplate.postForEntity(URI, entity, UserDto.class);
    }

    public UserDto updateUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept((List.of(MediaType.APPLICATION_JSON)));

        HttpEntity<UserDto> entity = new HttpEntity<>(UserDto.builder()
                .id(0L)
                .email("mattew@gmail.com")
                .password("123456")
                .role("admin")
                .firstName("Anthony")
                .lastName("Doe")
                .phoneNumber("380667874568")
                .build(), headers);

        return restTemplate.patchForObject(URI + 0, entity, UserDto.class);
    }

    public ResponseEntity<UserDto> getUserById() {
        return restTemplate.getForEntity(URI + 0, UserDto.class);
    }

    @GetMapping
    public String testTemplate() {
        return createUser().toString() + "\n"
                + getUserById() + "\n"
                + updateUser();
    }
}
