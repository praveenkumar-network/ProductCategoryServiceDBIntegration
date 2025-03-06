package com.example.productcategoryservicedbintegration.service;

import com.example.productcategoryservicedbintegration.model.Products;

import java.util.List;

public interface ProductService {
    public List<Products> getProductDetails();
    public Products getProductDetailsByProductId(Long id);
    public Products saveProductDetails(Products product);
    public Products updateProductDetails(Long productId, Products product);
    public Products partialUpdateProductDetails(Long productId, Products product);
    public boolean deleteProductDetails(Long productId);

}
