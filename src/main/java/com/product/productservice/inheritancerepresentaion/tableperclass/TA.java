package com.product.productservice.inheritancerepresentaion.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tc_ta")
public class TA extends User {
    private int noOfSessions;
    private double avgRating;
}
