package it.objectmethod.spring_tutorial.excepction;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}