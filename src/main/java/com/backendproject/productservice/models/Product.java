package com.backendproject.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Product extends BaseModel  { //product
    private String title;
    private Double price;
    private Category category;
}
