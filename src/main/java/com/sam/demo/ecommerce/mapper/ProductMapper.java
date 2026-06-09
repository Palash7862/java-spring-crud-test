package com.sam.demo.ecommerce.mapper;

import com.sam.demo.ecommerce.dto.CategoryResponseDto;
import com.sam.demo.ecommerce.dto.ProductRequestDto;
import com.sam.demo.ecommerce.dto.ProductResponseDto;
import com.sam.demo.ecommerce.entity.Category;
import com.sam.demo.ecommerce.entity.Product;
import com.sam.demo.ecommerce.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final CategoryRepository categoryRepository;

    public Product toEntity(ProductRequestDto dto, Category category) {
        Product product = new Product();
        product.setTitle(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setRegularPrice(dto.getRegularPrice());
        product.setSalePrice(dto.getSalePrice());
        product.setCategory(category);

        return product;
    }

    public ProductResponseDto toResponse(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .regularPrice(product.getRegularPrice())
                .salePrice(product.getSalePrice())
                .category(
                        CategoryResponseDto.builder()
                                .id(product.getCategory().getId())
                                .name(product.getCategory().getName())
                                .build()
                )
                .build();
    }
}