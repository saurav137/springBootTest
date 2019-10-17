package com.stackroute.userservice.service;

import com.stackroute.userservice.CustomException.UserAlreadyExist;
import com.stackroute.userservice.CustomException.UserNotFound;
import com.stackroute.userservice.domain.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user)throws UserAlreadyExist;

    public List<User> getALlUser();

    public void deleteUser(int id)throws UserNotFound;
    public User getTrackById(int id) throws UserNotFound;
    public User updateTrack(int id, String comment);
    public User getTrackByName(String trackByName);

}
