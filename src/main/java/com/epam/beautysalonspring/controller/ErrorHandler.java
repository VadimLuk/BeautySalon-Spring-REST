package com.epam.beautysalonspring.controller;


import com.epam.beautysalonspring.dto.ErrorDto;
import com.epam.beautysalonspring.exceptions.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleEntityNotFoundException(EntityNotFoundException exception){
        log.info("Handled EntityNotFoundException in RestControllerAdvice ErrorHandler");
        return ErrorDto.builder().errorMessage(exception.getMessage()).build();
    }
}
