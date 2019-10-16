package com.stackroute.userservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User  {

    @Id
    int trackId;
    String trackName;
    String comments;

     public User(){

     }

    public User(int trackId, String trackName, String comments) {
       this.trackId=trackId;
       this.trackName=trackName;
       this.comments=comments;
    }

    @Override
    public String toString() {
        return "User{" +
                "trackId=" + trackId +
                ", trackName='" + trackName + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
