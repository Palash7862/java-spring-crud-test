package com.sam.demo.ecommerce.controller;

import com.sam.demo.dto.ApiResponse;
import com.sam.demo.ecommerce.dto.ProductRequestDto;
import com.sam.demo.ecommerce.dto.ProductResponseDto;
import com.sam.demo.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ApiResponse<ProductResponseDto> create(@RequestBody @Valid ProductRequestDto dto) {
        ProductResponseDto product = productService.create(dto);

        return  new ApiResponse<>(
                HttpStatus.CREATED.value(),
                true,
                "Product created successfully",
                product
        );
    }

    @GetMapping
    public ApiResponse<List<ProductResponseDto>> getAll() {
        return new ApiResponse<>(
                HttpStatus.OK.value(),
                true,
                "Products fetch successfully",
                productService.getAll()
        );
    }

    @GetMapping("/by-category-where/{categoryId}")
    public ApiResponse<List<ProductResponseDto>> getAllByCategory(@PathVariable Long categoryId) {
        return new ApiResponse<>(
                HttpStatus.OK.value(),
                true,
                "Products fetch successfully",
                productService.getAllByCategoryId(categoryId)
        );
    }

    @GetMapping("/by-category/{categoryId}")
    public ApiResponse<List<ProductResponseDto>> getProductByCategory(@PathVariable Long categoryId) {
        return new ApiResponse<>(
                HttpStatus.OK.value(),
                true,
                "Products fetch successfully",
                productService.getProductByCategory(categoryId)
        );
    }
}
