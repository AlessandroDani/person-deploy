package com.example.deploy.exception;

public class PersonAlreadyExistException extends RuntimeException {
    public PersonAlreadyExistException(String message) {
        super("Persona ya existe con ese " + message);
    }
}
