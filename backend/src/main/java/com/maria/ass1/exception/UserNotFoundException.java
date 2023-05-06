package com.maria.ass1.exception;

public class UserNotFoundException extends  RuntimeException{

    public UserNotFoundException(Long id) {
        super("Nu se poate gasi user-ul cu id-ul:" + id);
    }
}
