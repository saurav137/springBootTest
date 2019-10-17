package com.stackroute.userservice.CustomException;


import com.stackroute.userservice.domain.User;

public class UserNotFound extends Exception {
    String message;
    public UserNotFound(){}

    public UserNotFound(String s){
        super(s);
        this.message=s;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
