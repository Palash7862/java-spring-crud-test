package com.sam.demo.job.service;

import com.sam.demo.job.dto.CategoryRequestDto;
import com.sam.demo.job.dto.CategoryResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    CategoryResponseDto create(CategoryRequestDto dto);

    List<CategoryResponseDto> getAll();

    CategoryResponseDto getById(Long id);

    CategoryResponseDto update(Long id, CategoryRequestDto dto);

    void  delete(Long id);
}
