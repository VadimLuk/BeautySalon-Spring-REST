package com.epam.beautysalonspring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class BeautySalonSpringApplication {

    public static void main(String[] args) {
        log.info("Started BeautySalon application");
        SpringApplication.run(BeautySalonSpringApplication.class, args);
    }

}