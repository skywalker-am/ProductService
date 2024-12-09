package com.backendproject.productservice.exceptions;

import lombok.Getter;

@Getter

public class ProductNotFoundException extends Exception{
    private Long id;

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Long id) {
        super(message);
        this.id = id;
    }

}
