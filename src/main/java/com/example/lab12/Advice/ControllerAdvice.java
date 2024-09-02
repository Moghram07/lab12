package com.example.lab12.Advice;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity DataIntegrityViolationException(DataIntegrityViolationException exception){
        String message = exception.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity EntityNotFoundException(EntityNotFoundException exception){
        String message = exception.getMessage();
        return ResponseEntity.status(404).body(message);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity HttpMessageNotReadableException(HttpMessageNotReadableException exception){
        String message = exception.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity NoResourceFoundException(NoResourceFoundException exception){
        String message = exception.getMessage();
        return ResponseEntity.status(404).body(message);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity IllegalArgumentException(IllegalArgumentException exception){
        String message = exception.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception){
        String message = exception.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException exception){
        String message = exception.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity RuntimeException(RuntimeException exception){
        String message = exception.getMessage();
        return ResponseEntity.status(500).body(message);
    }
}
