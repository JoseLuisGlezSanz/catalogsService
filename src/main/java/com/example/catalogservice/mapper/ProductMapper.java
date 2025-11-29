package com.example.catalogservice.mapper;

import com.example.catalogservice.dto.ProductRequest;
import com.example.catalogservice.dto.ProductResponse;
import com.example.catalogservice.model.Product;

public class ProductMapper {
    public static ProductResponse toResponse(Product product) {
        if (product == null) return null;
        
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .status(product.getStatus())
                .photo(product.getPhoto())
                .build();
    }

    public static Product toEntity(ProductRequest productRequest) {
        if (productRequest == null) return null;
        
        return Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .stock(productRequest.getStock())
                .status(productRequest.getStatus())
                .photo(productRequest.getPhoto())
                .build();
    }

    public static void copyToEntity(ProductRequest productRequest, Product entity) {
        if (productRequest == null || entity == null) return;
        
        entity.setName(productRequest.getName());
        entity.setPrice(productRequest.getPrice());
        entity.setStock(productRequest.getStock());
        entity.setStatus(productRequest.getStatus());
        entity.setPhoto(productRequest.getPhoto());
    }
}