package it.objectmethod.spring_tutorial.exepction;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}