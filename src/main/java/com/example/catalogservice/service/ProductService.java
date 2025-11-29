package com.example.catalogservice.service;

import java.util.List;

import com.example.catalogservice.dto.ProductRequest;
import com.example.catalogservice.dto.ProductResponse;

public interface ProductService {
    List<ProductResponse> findAll();
    ProductResponse findById(Long id);
    ProductResponse create(ProductRequest productRequest);
    ProductResponse update(Long id, ProductRequest productRequest);
    // void delete(Integer id);
    List<ProductResponse> getAll(int page, int pageSize);
    List<ProductResponse> findByName(String name);
    List<ProductResponse> findByStatus(Integer status);
    List<ProductResponse> findByStockLessThan(Integer stock);
}