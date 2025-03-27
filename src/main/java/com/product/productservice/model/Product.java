package com.product.productservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private Double price;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(referencedColumnName = "id", name = "category_id")
//    @JsonBackReference("testttt")
    private Category category;
    private String description;
    private String image;
}
