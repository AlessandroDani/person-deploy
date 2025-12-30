package com.example.deploy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
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

    @ExceptionHandler(SpringBootInitializationException.class)
    public ResponseEntity<Map<String, String>> handleSpringBootInitializationException(SpringBootInitializationException  springBootInitializationException) {
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap(MESSAGE, springBootInitializationException.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        errors.put("timestamp", LocalDateTime.now());
        errors.put("status", HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
