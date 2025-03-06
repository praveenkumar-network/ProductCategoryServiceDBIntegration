package com.example.productcategoryservicedbintegration.service.serviceImp;

import com.example.productcategoryservicedbintegration.dao.ProductServiceDao;
import com.example.productcategoryservicedbintegration.model.Products;
import com.example.productcategoryservicedbintegration.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductServiceDao productServiceDao;

    @Override
    public List<Products> getProductDetails() {
        List<Products> productsList = productServiceDao.findAll();
        return productsList;
    }

    @Override
    public Products getProductDetailsByProductId(Long id) {
        Optional<Products> products= productServiceDao.findById(id);
        if(products.isPresent()){
            return products.get();
        }
        return null;
    }

    @Override
    public Products saveProductDetails(Products products) {
        Products product= productServiceDao.save(products);
        return product;
    }

    @Override
    public Products updateProductDetails(Long productId, Products products) {
        Products product= productServiceDao.save(products);
           return product;
    }

    @Override
    public Products partialUpdateProductDetails(Long productId, Products product) {
        return null;
    }

    @Override
    public boolean deleteProductDetails(Long id) {
       Products products = getProductDetailsByProductId(id);
        productServiceDao.delete(products);
        return false;
    }
}
