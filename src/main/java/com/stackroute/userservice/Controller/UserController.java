package com.stackroute.userservice.Controller;

import com.stackroute.userservice.CustomException.UserAlreadyExist;
import com.stackroute.userservice.CustomException.UserNotFound;
import com.stackroute.userservice.applicationListener.ApplicationRefreshedListener;
import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="api/v1")
public class UserController {
   //  @Autowired
    public UserService userService;
    public UserController(UserService userService){
         this.userService=userService;
        ;
     }




    @PostMapping("user")
     public ResponseEntity<?>  saveUser(@RequestBody User user) throws UserAlreadyExist {
         ResponseEntity responseEntity;

             userService.saveUser(user);
             responseEntity = new ResponseEntity("Succesfully Created", HttpStatus.CREATED);

         return responseEntity;
     }
     @GetMapping("user")
    public ResponseEntity<?> getAllUser(){
         try {
             return new ResponseEntity<List<User>>(userService.getALlUser(),HttpStatus.OK);

         }
         catch (Exception ex){
             return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
         }
     }
    @GetMapping("track/{trackId}")
    public ResponseEntity<?> getUser(@PathVariable int trackId) {
        try {
            return new ResponseEntity<User>(userService.getTrackById(trackId), HttpStatus.OK);

        } catch (UserNotFound ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }
     @DeleteMapping(value = "user/{trackId}")
     public ResponseEntity<?> deleteUser(@PathVariable int trackId){
         try {
             userService.deleteUser(trackId);
             return new ResponseEntity<String>("Succesfully Deleted",HttpStatus.OK);

         }
         catch (UserNotFound ex){
             return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
         }
     }
    @PutMapping(value = "/update/{id}/{comment}")
    public ResponseEntity<?> updateTrack(@PathVariable int id, @PathVariable String comment) {

        ResponseEntity responseEntity;

        try {
            userService.updateTrack(id,comment);
            responseEntity = new ResponseEntity<>(userService.getTrackById(id), HttpStatus.CREATED);
        }
        catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;

    }
    @GetMapping(value = "/getTrackByName/{trackByName}")
    public ResponseEntity<?> getTrackByName(@PathVariable String trackByName){
    ResponseEntity responseEntity;
        try {
            userService.getTrackByName(trackByName);
            responseEntity = new ResponseEntity<User>(userService.getTrackByName(trackByName), HttpStatus.CREATED);
        }
        catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }





}
