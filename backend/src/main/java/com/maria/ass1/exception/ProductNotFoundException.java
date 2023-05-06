package com.maria.ass1.exception;

public class ProductNotFoundException extends  RuntimeException{
    public ProductNotFoundException(Long id) {
        super("Nu se poate gasi raportul pt somn cu id-ul:" + id);
    }
}
