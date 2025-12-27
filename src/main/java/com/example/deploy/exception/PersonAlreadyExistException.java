package com.example.deploy.exception;

public class PersonAlreadyExistException extends RuntimeException {
    public PersonAlreadyExistException() {
        super("Persona ya existe con ese identificador");
    }
}
