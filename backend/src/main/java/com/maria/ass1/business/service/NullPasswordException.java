package com.maria.ass1.business.service;

public class NullPasswordException extends RuntimeException{
    public NullPasswordException(String message){

        super(message);
    }

    public NullPasswordException(){

        super("NULL password!");
    }
}
