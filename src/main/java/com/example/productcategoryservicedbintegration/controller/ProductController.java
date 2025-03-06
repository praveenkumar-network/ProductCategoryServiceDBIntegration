package com.example.productcategoryservicedbintegration.controller;

import com.example.productcategoryservicedbintegration.dto.CategoryDto;
import com.example.productcategoryservicedbintegration.dto.ProductsDto;
import com.example.productcategoryservicedbintegration.model.Category;
import com.example.productcategoryservicedbintegration.model.Products;
import com.example.productcategoryservicedbintegration.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/products/{id}")
    public ProductsDto getProductDetailsByProductId(@PathVariable Long id){
        System.out.println("#####################  getProductDetails  #########################");
        return modelToDtoConversion(productService.getProductDetailsByProductId(id));
    }

    @GetMapping("/products")
    public List<ProductsDto> getProductDetails(){
       List<Products> productsList = productService.getProductDetails();
       List<ProductsDto> productsDtoList = new ArrayList<>();
       for (Products products : productsList) {
           ProductsDto  productsDto = modelToDtoConversion(products);
           productsDtoList.add(productsDto);
       }
        return productsDtoList;
    }

    @PostMapping("/products")
    public ProductsDto saveProductDetails(@RequestBody ProductsDto productsDto) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String s =mapper.writeValueAsString(productsDto);
        System.out.println("saveProductDetails :: Request :  "+s);
        Products productsRequest = dtoToModelConversion(productsDto);
        Products productsResponse = productService.saveProductDetails(productsRequest);
        return modelToDtoConversion(productsResponse);
    }

    @PutMapping("/products/{productId}")
    public ProductsDto updateProductDetails(@PathVariable Long productId ,@RequestBody ProductsDto productsDto){
        Products productsRequest = dtoToModelConversion(productsDto);
        Products productsResponse = productService.updateProductDetails(productId , productsRequest);
        return modelToDtoConversion(productsResponse);
    }
//
//    @PatchMapping("/products/{productId}")
//    public ProductsDto partialUpdateProductDetails(@PathVariable Long productId ,@RequestBody ProductsDto productsDto){
//        return modelToDtoConversion(productService.partialUpdateProductDetails(productId , productsDto));
//    }
//
    @DeleteMapping("/products/{productId}")
    public boolean deleteProductDetails(@PathVariable Long productId){
        return productService.deleteProductDetails(productId);
    }
    private ProductsDto modelToDtoConversion(Products product) {
        ProductsDto dto = new ProductsDto();
        dto.setId(product.getId());
        dto.setImageURL(product.getImageURL());
        dto.setCategory(product.getCategory());
        dto.setDescription(product.getDescription());
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(product.getCategorys().getId());
        categoryDto.setName(product.getCategorys().getName());
        categoryDto.setDescription(product.getCategorys().getDescription());

        dto.setCategorys(categoryDto);
        return dto;
    }
    private Products dtoToModelConversion(ProductsDto dto) {
        Category category = new Category();
        category.setName(dto.getCategorys().getName());
        category.setDescription(dto.getCategorys().getDescription());


        Products product = new Products();
        product.setImageURL(dto.getImageURL());
        product.setCategory(dto.getCategory());
        product.setDescription(dto.getDescription());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setCategorys(category);

        return product;
    }
}
