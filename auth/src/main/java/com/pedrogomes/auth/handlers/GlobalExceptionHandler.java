package com.pedrogomes.auth.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pedrogomes.auth.exceptions.GeneratingTokenException;
import com.pedrogomes.auth.exceptions.ProductNotFoundException;
import com.pedrogomes.auth.exceptions.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String>HandleProductNotFound(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String>HandleUserNotFound(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ExceptionHandler(GeneratingTokenException.class)
    public ResponseEntity<String>HandleGeneratingTokenException(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
