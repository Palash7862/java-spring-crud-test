//package com.sam.demo.exception;
//
//import com.sam.demo.dto.ApiResponse;
//import com.sam.demo.util.ResponseBuilder;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//
//public class GlobalExceptionHandlerByBuilder {
//
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ApiResponse<Void> handle(ResourceNotFoundException ex) {
//        return ResponseBuilder.error(
//                HttpStatus.NOT_FOUND,
//                ex.getMessage()
//        );
//    }
//
//    @ExceptionHandler(DuplicateResourceException.class)
//    public ApiResponse<Void> handle(DuplicateResourceException ex) {
//        return ResponseBuilder.error(
//                HttpStatus.CONFLICT,
//                ex.getMessage()
//        );
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ApiResponse<Void> handleGeneric(Exception ex) {
//        return ResponseBuilder.error(
//                HttpStatus.INTERNAL_SERVER_ERROR,
//                ex.getMessage()
//        );
//    }
//}
