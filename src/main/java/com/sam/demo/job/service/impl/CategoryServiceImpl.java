package com.sam.demo.job.service.impl;

import com.sam.demo.exception.ResourceNotFoundException;
import com.sam.demo.job.dto.CategoryRequestDto;
import com.sam.demo.job.dto.CategoryResponseDto;
import com.sam.demo.job.entity.Category;
import com.sam.demo.job.mapper.CategoryMapper;
import com.sam.demo.job.repository.CategoryRepository;
import com.sam.demo.job.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponseDto create(CategoryRequestDto dto) {
        Category category = categoryMapper.toEntity(dto);
        Category saved = categoryRepository.save(category);

        return categoryMapper.toResponse(saved);
    }

    @Override
    public List<CategoryResponseDto> getAll() {

        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponse)
                .toList();
    }

    @Override
    public CategoryResponseDto getById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        return categoryMapper.toResponse(category);
    }

    @Override
    public CategoryResponseDto update(Long id, CategoryRequestDto dto) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        categoryMapper.updateEntity(category, dto);
        Category updated = categoryRepository.save(category);

        return  categoryMapper.toResponse(category);
    }

    @Override
    public void delete(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        categoryRepository.delete(category);
    }
}
