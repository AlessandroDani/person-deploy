package com.example.deploy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "message";

    @ExceptionHandler(PersonAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> handlePersonAlreadyExistException(PersonAlreadyExistException  personAlreadyExistException) {
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(MESSAGE, personAlreadyExistException.getMessage()));
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePersonNotFoundException(PersonNotFoundException  personNotFoundException) {
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(MESSAGE, personNotFoundException.getMessage()));
    }

}
