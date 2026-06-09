package com.sam.demo.ecommerce.service;

import com.sam.demo.ecommerce.dto.ProductRequestDto;
import com.sam.demo.ecommerce.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto create(ProductRequestDto dto);

    List<ProductResponseDto> getAll();

    ProductResponseDto getById(Long id);

    ProductResponseDto update(ProductRequestDto dto, Long id);

    void delete(Long id);

    List<ProductResponseDto> getAllByCategoryId(Long categoryId);

    List<ProductResponseDto> getProductByCategory(Long categoryId);
}
