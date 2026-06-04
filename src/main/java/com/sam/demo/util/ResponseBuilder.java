package com.sam.demo.util;

import com.sam.demo.dto.ApiResponse;
import org.springframework.http.HttpStatus;

public class ResponseBuilder {

    public static <T> ApiResponse<T> success(
            HttpStatus status,
            String message,
            T data) {

        ApiResponse<T> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setStatus(status.value());
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    public static <T> ApiResponse<T> error(
            HttpStatus status,
            String message) {

        ApiResponse<T> response = new ApiResponse<>();
        response.setSuccess(false);
        response.setStatus(status.value());
        response.setMessage(message);
        response.setData(null);
        return response;
    }
}
