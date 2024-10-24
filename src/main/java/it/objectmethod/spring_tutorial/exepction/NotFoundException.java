package it.objectmethod.spring_tutorial.exepction;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
