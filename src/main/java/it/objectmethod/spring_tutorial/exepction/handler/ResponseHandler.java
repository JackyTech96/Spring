package it.objectmethod.spring_tutorial.exepction.handler;

import org.springframework.http.ResponseEntity;

@FunctionalInterface
public interface ResponseHandler<T> {
    ResponseEntity<T> handle() throws Exception;
}

