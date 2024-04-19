package com.pedrogomes.auth.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pedrogomes.auth.exceptions.ProductNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String>HandleProductNotFound(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
