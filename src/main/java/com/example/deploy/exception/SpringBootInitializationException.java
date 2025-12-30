package com.example.deploy.exception;

public class SpringBootInitializationException extends RuntimeException {
    public SpringBootInitializationException() {
        super("No se pudo inicializar Spring Boot");
    }
}
