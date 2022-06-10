package com.revature.movieapp.util.aspects;


import com.revature.movieapp.util.exceptions.AuthenticationException;
import com.revature.movieapp.util.exceptions.InvalidRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Becuase this aspect was so common we leverage something knows as a @RestControllerAdvice
@RestControllerAdvice
public class ErrorExceptionAspect {
    @ExceptionHandler({InvalidRequestException.class})
    public ResponseEntity<String> handleException(Exception e){
        String message = "Caught the invalid request with : " + e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AuthenticationException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED) // only use with void, if you plan to return some JSON body you have to use ResponseEntity<>
    public void handleException2(Exception e){
        String message = "Caught the invalid request2 with : " + e.getMessage();
        System.out.println(message);
    }
}
