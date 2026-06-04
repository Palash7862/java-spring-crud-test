package com.sam.demo.ecommerce.service;

import com.sam.demo.ecommerce.dto.CategoryRequestDto;
import com.sam.demo.ecommerce.dto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {

    CategoryResponseDto create(CategoryRequestDto dto);

    List<CategoryResponseDto> getAll();

    CategoryResponseDto getById(Long id);

    CategoryResponseDto update(Long id, CategoryRequestDto dto);

    void  delete(Long id);
}
