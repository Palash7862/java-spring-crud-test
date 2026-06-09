package com.sam.demo.ecommerce.controller;

import com.sam.demo.dto.ApiResponse;
import com.sam.demo.ecommerce.dto.CategoryRequestDto;
import com.sam.demo.ecommerce.dto.CategoryResponseDto;
import com.sam.demo.ecommerce.service.CategoryService;
import com.sam.demo.util.ResponseBuilder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Category APIs", description = "Operations related to Category")
@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    @Operation(summary = "Create Category", description = "Create a new Category")
    public ApiResponse<CategoryResponseDto> create(@RequestBody @Valid CategoryRequestDto dto) {
        CategoryResponseDto category = categoryService.create(dto);

        return new ApiResponse<>(
                HttpStatus.CREATED.value(),
                true,
                "Category created successfully",
                category
        );
        /*
        return ResponseBuilder.success(
                HttpStatus.CREATED,
                "Category created successfully",
                categoryService.create(dto)
        );
         */
    }

    @GetMapping
    public ApiResponse<List<CategoryResponseDto>> getAll() {

        return ResponseBuilder.success(
                HttpStatus.OK,
                "Category fetch successfully",
                categoryService.getAll()
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<CategoryResponseDto> getById(@PathVariable Long id) {

        return ResponseBuilder.success(
                HttpStatus.OK,
                "Category fetch successfully",
                categoryService.getById(id)
        );
    }

    @PutMapping("/{id}")
    public ApiResponse<CategoryResponseDto> update(@PathVariable Long id, @RequestBody @Valid CategoryRequestDto dto) {

        return ResponseBuilder.success(
                HttpStatus.OK,
                "Category created successfully",
                categoryService.update(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<CategoryResponseDto> delete(@PathVariable Long id) {

        categoryService.delete(id);

        return ResponseBuilder.success(
                HttpStatus.OK,
                "Category created successfully",
                null
        );
    }
}
