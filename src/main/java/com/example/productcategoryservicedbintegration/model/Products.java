package com.example.productcategoryservicedbintegration.model;

import com.example.productcategoryservicedbintegration.dto.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Products extends BaseModel {
    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private double price;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "imageURL")
    private String imageURL;

    @Column(name = "isPrime")
    private boolean isPrime;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category categorys;

}
