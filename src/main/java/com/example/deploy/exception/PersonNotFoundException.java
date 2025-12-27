package com.example.deploy.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException() {
        super("Persona no encontrada");
    }
}
