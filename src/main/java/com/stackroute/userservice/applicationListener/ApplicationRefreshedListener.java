package com.stackroute.userservice.applicationListener;

import com.stackroute.userservice.CustomException.UserAlreadyExist;
import com.stackroute.userservice.CustomException.UserNotFound;
import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    public UserService userService;

    public ApplicationRefreshedListener(UserService userService) {
        this.userService=userService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            User user = new User(12, "rohit", "sharma");
            userService.saveUser(user);
        }catch (UserAlreadyExist | UserNotFound ex){
            System.out.println(ex.getMessage());
        }
        try {
            User user2=new User(22,"virat","kohli");
            userService.saveUser(user2);
        }catch (UserAlreadyExist | UserNotFound ex){
            System.out.println(ex.getMessage());
        }


    }
}
