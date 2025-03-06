package com.example.productcategoryservicedbintegration.model;

import com.example.productcategoryservicedbintegration.dto.BaseModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Category extends BaseModel{

    private String name;
    private String description;

    @OneToMany(mappedBy = "categorys")
    private List<Products> products;
}
