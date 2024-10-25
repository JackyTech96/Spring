package it.objectmethod.spring_tutorial.excepction;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
