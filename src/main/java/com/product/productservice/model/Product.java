package com.product.productservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    public Product(ProductDTO productDTO) {
        super.setId( productDTO.getId());
        this.title = productDTO.getTitle();
        this.description = productDTO.getDescription();
        this.price = productDTO.getPrice();
        this.image = productDTO.getImage();
//        this.category = new Category(productDTO.getCategory());
    }

    public Product() {
    }


    private String title;
    private Double price;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(referencedColumnName = "id", name = "category_id")
//    @JsonBackReference("testttt")
    private Category category;
    private String description;
    private String image;
}
