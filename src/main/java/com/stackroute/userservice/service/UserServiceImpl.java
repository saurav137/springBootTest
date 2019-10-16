package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{


   public  UserRepository userRepository;
   @Autowired
   public UserServiceImpl(UserRepository userRepository){
       this.userRepository=userRepository;
   }
    @Override
    public User saveUser(User user) {
       User savedUser=userRepository.save(user);
        return savedUser;
    }

    @Override
    public List<User> getALlUser() {
        return userRepository.findAll();
    }

    @Override
    public User getTrackById(int id) {
        User user= userRepository.findById(id).get();
        return user;
    }
    @Override
    public void deleteUser(int id){
        userRepository.delete(getTrackById(id));
    }

    @Override
    public User updateTrack(int id, String comment) {
        User toUpdateUser = userRepository.findById(id).get();
        toUpdateUser.setComments(comment);
        User savedTrack = userRepository.save(toUpdateUser);
        return savedTrack;
    }
}
