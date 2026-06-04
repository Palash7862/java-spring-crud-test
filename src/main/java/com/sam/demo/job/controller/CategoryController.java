package com.sam.demo.job.controller;

import com.sam.demo.helper.ApiResponse;
import com.sam.demo.job.dto.CategoryRequestDto;
import com.sam.demo.job.dto.CategoryResponseDto;
import com.sam.demo.job.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryResponseDto>> create(@RequestBody @Valid CategoryRequestDto dto) {
        CategoryResponseDto category = categoryService.create(dto);

        ApiResponse<CategoryResponseDto> response = ApiResponse.<CategoryResponseDto>builder()
                .success(true)
                .message("Category created successfully")
                .data(category)
                .build();

        return  ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryResponseDto>>> getAll() {
        List<CategoryResponseDto> categories = categoryService.getAll();

        ApiResponse<List<CategoryResponseDto>> response = ApiResponse.<List<CategoryResponseDto>>builder()
                .success(true)
                .message("Categories fetched successfully")
                .data(categories)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponseDto>> getById(@PathVariable Long id) {
        CategoryResponseDto category = categoryService.getById(id);

        ApiResponse<CategoryResponseDto> response = ApiResponse.<CategoryResponseDto>builder()
                .success(true)
                .message("Category fetched successfully")
                .data(category)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponseDto>> update(@PathVariable Long id, @RequestBody @Valid CategoryRequestDto dto) {
        CategoryResponseDto category = categoryService.update(id, dto);

        ApiResponse<CategoryResponseDto> response = ApiResponse.<CategoryResponseDto>builder()
                .success(true)
                .message("Category updated successfully")
                .data(category)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        categoryService.delete(id);

        ApiResponse<Void> response = ApiResponse.<Void>builder()
                        .success(true)
                        .message("Category deleted successfully")
                        .build();

        return ResponseEntity.ok(response);
    }
}
