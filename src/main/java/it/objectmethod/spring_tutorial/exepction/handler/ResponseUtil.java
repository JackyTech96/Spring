package it.objectmethod.spring_tutorial.exepction.handler;


import it.objectmethod.spring_tutorial.exepction.NotFoundException;
import it.objectmethod.spring_tutorial.exepction.ValidationException;
import it.objectmethod.spring_tutorial.exepction.body.ErrorDetails;
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
        } catch (Exception e) {
            final ErrorDetails errorDetails = new ErrorDetails(
                    LocalDateTime.now(),
                    e.getMessage(),
                    request.getRequestURI(),
                    HttpStatus.NOT_FOUND
            );
            return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
