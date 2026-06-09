package com.sam.demo.ecommerce.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequestDto {

    @NotBlank(message = "Product title is required")
    private String title;

    private String description;

    @DecimalMin("1.0")
    private BigDecimal regularPrice;

    @DecimalMin("1.0")
    private BigDecimal salePrice;

    @NotNull(message = "Category is required")
    private Long categoryId;

}
