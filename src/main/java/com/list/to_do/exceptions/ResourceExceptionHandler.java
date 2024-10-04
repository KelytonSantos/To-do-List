package com.list.to_do.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<StandardError> notFound(ResourceNotFound e, HttpServletRequest request) {
        String error = "Resource Not Found";
        HttpStatus statusCode = HttpStatus.NOT_FOUND;

        StandardError buildingError = new StandardError(Instant.now(), statusCode.value(), error, e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(statusCode).body(buildingError);
    }
}
