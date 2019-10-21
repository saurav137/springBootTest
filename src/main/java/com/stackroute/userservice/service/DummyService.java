package com.stackroute.userservice.service;

import com.stackroute.userservice.CustomException.UserAlreadyExist;
import com.stackroute.userservice.CustomException.UserNotFound;
import com.stackroute.userservice.domain.User;
//import com.stackroute.userservice.repository.MongoRepositoryclass;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Profile("dev")
public class DummyService implements UserService {


    public UserRepository userRepository;
    @Autowired
    public DummyService(UserRepository userRepository){
        System.out.println("this one used dev profile");
        this.userRepository=userRepository;
    }
    @Override
    public User saveUser(User user)throws UserAlreadyExist {
        try{
            getTrackById(user.getTrackId());
            throw new UserAlreadyExist("User Already Exist exception");
        } catch(UserNotFound ex){
            User savedUser=userRepository.save(user);
            return savedUser;
        }

    }

    @Override
    public List<User> getALlUser() {
        return userRepository.findAll();
    }

    @Override
    public User getTrackById(int id) throws UserNotFound {
        try {
            User user = userRepository.findById(id).get();
            return user;
        }
        catch(Exception ex){
            throw new UserNotFound("User Not Found Exception");

        }

    }
    @Override
    public void deleteUser(int id)throws UserNotFound{
        try {
            User user = userRepository.findById(id).get();
            userRepository.delete(getTrackById(id));
        }
        catch(Exception ex){
            throw new UserNotFound("User Not Found Exception");

        }

    }

    @Override
    public User updateTrack(int id, String comment) {
        User toUpdateUser = userRepository.findById(id).get();
        toUpdateUser.setComments(comment);
        User savedTrack = userRepository.save(toUpdateUser);
        return savedTrack;
    }

    @Override
    public List<User> getTrackByName(String trackByName) {
        return null;
    }
}
