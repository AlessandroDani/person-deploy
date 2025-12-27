package com.example.deploy.exception;

public class PersonAlreadyExistException extends RuntimeException {
    public PersonAlreadyExistException() {
        super("Persona con ese documento de identidad ya existe");
    }
}
