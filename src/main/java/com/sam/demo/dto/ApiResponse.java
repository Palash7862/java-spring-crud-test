package com.sam.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private int status;

    private boolean success;

    private String message;

    private T data;
}
