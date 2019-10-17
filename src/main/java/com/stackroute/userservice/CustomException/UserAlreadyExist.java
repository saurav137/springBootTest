package com.stackroute.userservice.CustomException;

public class UserAlreadyExist extends Exception {
    String message;
    public UserAlreadyExist(){}

    public UserAlreadyExist(String s){
        super(s);
        this.message=s;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
