package com.backendproject.productservice.services;

import com.backendproject.productservice.exceptions.ProductNotFoundException;
import com.backendproject.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);
}
