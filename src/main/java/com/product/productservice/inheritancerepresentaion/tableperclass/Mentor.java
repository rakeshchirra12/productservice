package com.product.productservice.inheritancerepresentaion.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tc_mentor")
public class Mentor extends User {
    private double avgRating;
}
