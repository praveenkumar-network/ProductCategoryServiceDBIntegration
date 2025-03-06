package com.example.productcategoryservicedbintegration.dao;

import com.example.productcategoryservicedbintegration.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductServiceDao extends JpaRepository<Products, Long> {

}
