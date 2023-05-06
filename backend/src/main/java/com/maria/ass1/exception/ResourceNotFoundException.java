package com.maria.ass1.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Object fieldValue;
    private HttpStatus status;
    public ResourceNotFoundException(){

    }
    @Builder
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue, HttpStatus status){
        super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue));
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;
        this.resourceName=resourceName;
        this.status=status;
    }

    public String getResourceName() {
        return resourceName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
