package com.example.productcategoryservicedbintegration.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductsDto extends BaseModel{
    private String title;
    private double price;
    private String category;
    private String description;
    private String imageURL;
    private CategoryDto categorys;

}
