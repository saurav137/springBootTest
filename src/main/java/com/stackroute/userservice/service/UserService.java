package com.stackroute.userservice.service;

import com.stackroute.userservice.CustomException.UserAlreadyExist;
import com.stackroute.userservice.CustomException.UserNotFound;
import com.stackroute.userservice.domain.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user) throws UserAlreadyExist, UserNotFound;

    public List<User> getALlUser ()throws UserNotFound;

    public void deleteUser(int id)throws UserNotFound;
    public User getTrackById(int id) throws UserNotFound;
    public User updateTrack(int id, String comment);
    public List<User> getTrackByName(String trackByName);

}
