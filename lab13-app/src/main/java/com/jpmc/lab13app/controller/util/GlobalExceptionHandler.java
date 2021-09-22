package com.jpmc.lab13app.controller.util;

import com.jpmc.lab13app.exception.PersonNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ErrorInformation> handlePersonNotFoundException(PersonNotFoundException ex, WebRequest webRequest) {
        String errorMessage = "Person with id " + ex.getMessage() + " is not found";
        ErrorInformation info = new ErrorInformation();
        info.setMessage(errorMessage);
        info.setTimestamp(LocalDateTime.now());
        info.setPath(webRequest.getDescription(false));
        logger.error("-------Person not found with {} while accessing {}", ex.getMessage(), webRequest.getDescription(true));
        return new ResponseEntity<>(info, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInformation> handleException(Exception ex, WebRequest webRequest) {
        ErrorInformation info = new ErrorInformation();
        info.setMessage(ex.getMessage());
        info.setTimestamp(LocalDateTime.now());
        info.setPath(webRequest.getDescription(false));
        logger.error("-------Exception {} occurred while accessing {}", ex.getMessage(), webRequest.getDescription(true));
        return new ResponseEntity<>(info, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
