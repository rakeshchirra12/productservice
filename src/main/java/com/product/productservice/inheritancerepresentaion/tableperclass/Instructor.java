package com.product.productservice.inheritancerepresentaion.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tc_instructor")
public class Instructor extends User {
    private String specialization;
}
