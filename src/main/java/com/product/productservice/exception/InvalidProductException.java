package com.product.productservice.exception;

public class InvalidProductException extends Throwable {
    public InvalidProductException(String productEmpty) {
        super(productEmpty);
    }
}
