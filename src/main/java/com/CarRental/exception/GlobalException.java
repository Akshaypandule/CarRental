package com.CarRental.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<String> HandleResourceNotFoundException(ResourceNotFound ex){
        String message = ex.getMessage();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String>handleInvalidDetails(DataIntegrityViolationException ex){
        return new ResponseEntity<>("Email address is already in use",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleNotVAlidException(MethodArgumentNotValidException ex) {

        Map<String, String> map = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(errors -> {
            String filed = ((FieldError) errors).getField();
            String defaultMessage = errors.getDefaultMessage();

            map.put(filed, defaultMessage);

        });

        return new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);

    }
    
}
