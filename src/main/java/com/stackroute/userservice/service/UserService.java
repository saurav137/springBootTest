package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);

    public List<User> getALlUser();

    public void deleteUser(int id);
    public User getTrackById(int id);
    public User updateTrack(int id, String comment);

}
