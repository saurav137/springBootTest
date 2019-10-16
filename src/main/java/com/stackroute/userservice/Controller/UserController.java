package com.stackroute.userservice.Controller;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserService;
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

    public UserService userService;
    public UserController(UserService userService){
         this.userService=userService;
     }





    @PostMapping("user")
     public ResponseEntity<?>  saveUser(@RequestBody User user){
         ResponseEntity responseEntity;
         try{
             userService.saveUser(user);
             responseEntity = new ResponseEntity("Succesfully Created", HttpStatus.CREATED);
         } catch (Exception ex){
             responseEntity =new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
         }

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

     @DeleteMapping(value = "user/{trackId}")
     public ResponseEntity<?> deleteUser(@PathVariable int trackId){
         try {
             userService.deleteUser(trackId);
             return new ResponseEntity<String>("Succesfully Deleted",HttpStatus.OK);

         }
         catch (Exception ex){
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



}
