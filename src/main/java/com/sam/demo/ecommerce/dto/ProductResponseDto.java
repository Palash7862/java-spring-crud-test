package com.sam.demo.ecommerce.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductResponseDto {

    private Long id;

    private String title;

    private String description;

    private BigDecimal regularPrice;

    private BigDecimal salePrice;

    private CategoryResponseDto category;
}
