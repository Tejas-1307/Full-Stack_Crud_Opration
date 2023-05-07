package com.crud.fullstack.backend.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id){
       super("could not found user"+id);
    }
}
