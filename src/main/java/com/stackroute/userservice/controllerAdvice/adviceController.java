package com.stackroute.userservice.controllerAdvice;

import com.stackroute.userservice.CustomException.UserAlreadyExist;
import com.stackroute.userservice.CustomException.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class adviceController {

        @ResponseBody
        @ExceptionHandler(UserAlreadyExist.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public String trackExistsAdvice(UserAlreadyExist ex) {
            return ex.getMessage();
        }

        @ResponseBody
        @ExceptionHandler(UserNotFound.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public String NotFoundAdvice(UserAlreadyExist ex) {
            return ex.getMessage();
        }

}
