package com.sam.demo.ecommerce.mapper;

import com.sam.demo.ecommerce.dto.CategoryRequestDto;
import com.sam.demo.ecommerce.dto.CategoryResponseDto;
import com.sam.demo.ecommerce.entity.Category;
import org.springframework.stereotype.Component;


@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequestDto dto) {
        Category category = new Category();
        category.setName(dto.getName());

        return category;
    }

    public  CategoryResponseDto toResponse(Category category) {
        return CategoryResponseDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public  void updateEntity(Category category, CategoryRequestDto dto) {
        category.setName(dto.getName());
    }
}
