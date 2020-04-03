package com.jwttesting.jwtTesting.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class CustomExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleUsernameNotUnique(UsernameNotUniqueException ex){

        UsernameNotUniqueResponse usernameNotUniqueResponse = new UsernameNotUniqueResponse(ex.getLocalizedMessage());

        return new ResponseEntity(usernameNotUniqueResponse, HttpStatus.BAD_REQUEST);
    }
}
