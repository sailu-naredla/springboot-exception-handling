package com.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorResponse message = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ErrorResponse>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> badRequestException(BadRequestException ex, WebRequest request) {
        ErrorResponse message = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ErrorResponse>(message, HttpStatus.BAD_REQUEST);
    }

    /*@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorResponse message = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ErrorResponse>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/
}
