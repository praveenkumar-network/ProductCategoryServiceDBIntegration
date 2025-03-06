package com.example.productcategoryservicedbintegration.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryDto extends  BaseModel {
    private String name;
    private String description;
    private String type;
    private List<ProductsDto> produtcs;

}
