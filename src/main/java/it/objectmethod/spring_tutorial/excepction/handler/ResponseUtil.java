package it.objectmethod.spring_tutorial.excepction.handler;


import it.objectmethod.spring_tutorial.excepction.NotFoundException;
import it.objectmethod.spring_tutorial.excepction.ValidationException;
import it.objectmethod.spring_tutorial.excepction.body.ErrorDetails;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ResponseUtil {


    public static <T> ResponseEntity<T> execute(final ResponseHandler<T> handler, final HttpServletRequest request) {
        try {
            return handler.handle();
        } catch (ValidationException e) {
            final ErrorDetails errorDetails = new ErrorDetails(
                    LocalDateTime.now(),
                    e.getMessage(),
                    request.getRequestURI(),
                    HttpStatus.BAD_REQUEST
            );
            return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
        } catch (NotFoundException e) {
            final ErrorDetails errorDetails = new ErrorDetails(
                    LocalDateTime.now(),
                    e.getMessage(),
                    request.getRequestURI(),
                    HttpStatus.NOT_FOUND
            );
            return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
//        } catch (IllegalArgumentException e) {
//            final ErrorDetails errorDetails = new ErrorDetails(
//                    LocalDateTime.now(),
//                    "Tipo di parametro errato " + e.getMessage(),
//                    request.getRequestURI(),
//                    HttpStatus.BAD_REQUEST
//            );
//            return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            final ErrorDetails errorDetails = new ErrorDetails(
                    LocalDateTime.now(),
                    e.getMessage(),
                    request.getRequestURI(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
            return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
