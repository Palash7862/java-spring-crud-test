package com.sam.demo.ecommerce.service.impl;

import com.sam.demo.ecommerce.dto.ProductRequestDto;
import com.sam.demo.ecommerce.dto.ProductResponseDto;
import com.sam.demo.ecommerce.entity.Category;
import com.sam.demo.ecommerce.entity.Product;
import com.sam.demo.ecommerce.mapper.ProductMapper;
import com.sam.demo.ecommerce.repository.CategoryRepository;
import com.sam.demo.ecommerce.repository.ProductRepository;
import com.sam.demo.ecommerce.service.ProductService;
import com.sam.demo.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponseDto create(ProductRequestDto dto) {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() ->new ResourceNotFoundException("Category not found"));

        Product product = productMapper.toEntity(dto, category);

        Product saved =  productRepository.save(product);

        return  productMapper.toResponse(saved);
    }

    @Override
    public List<ProductResponseDto> getAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }

    @Override
    public ProductResponseDto getById(Long id) {
        return null;
    }

    @Override
    public ProductResponseDto update(ProductRequestDto dto, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ProductResponseDto> getAllByCategoryId(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        return productRepository.findByCategoryId(categoryId)
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }

    @Override
    public List<ProductResponseDto> getProductByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        return category.getProductList()
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }
}
