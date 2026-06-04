package com.sam.demo.ecommerce.service.impl;

import com.sam.demo.exception.DuplicateResourceException;
import com.sam.demo.exception.ResourceNotFoundException;
import com.sam.demo.ecommerce.dto.CategoryRequestDto;
import com.sam.demo.ecommerce.dto.CategoryResponseDto;
import com.sam.demo.ecommerce.entity.Category;
import com.sam.demo.ecommerce.mapper.CategoryMapper;
import com.sam.demo.ecommerce.repository.CategoryRepository;
import com.sam.demo.ecommerce.service.CategoryService;
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
        if(categoryRepository.findByName(dto.getName()).isPresent()) {
            throw new DuplicateResourceException("Category already exists");
        }

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
