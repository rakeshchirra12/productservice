package com.product.productservice.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class NewTable extends BaseModel{
    private String testColumn;
}
