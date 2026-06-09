package com.sam.demo.exception;

import com.sam.demo.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiResponse<Void> handle(ResourceNotFoundException ex) {
        return new ApiResponse<>(
                HttpStatus.NOT_FOUND.value(),
                false,
                ex.getMessage(),
                null
        );
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ApiResponse<Void> handle(DuplicateResourceException ex) {
        return new ApiResponse<>(
                HttpStatus.CONFLICT.value(),
                false,
                ex.getMessage(),
                null
        );
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<Void> handleGeneric(Exception ex) {
        return new ApiResponse<>(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                false,
                ex.getMessage(),
                null
        );
    }
}
