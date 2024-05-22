package com.product.productservice.inheritancerepresentaion.mappersuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_mentor")
public class Mentor extends User {
    private double avgRating;
}
