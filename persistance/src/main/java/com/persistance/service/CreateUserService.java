package com.persistance.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.persistance.dto.UserDTO;
import com.persistance.itc.ITCCreateUser;

@Component
public class CreateUserService {

    @Autowired
    ITCCreateUser tCCreateUser;

    private static final Logger log = LoggerFactory.getLogger(CreateUserService.class);

    public String createUser(UserDTO user) {
        
        log.info("Inside method createUser of CreateUserService with inputs :: "+user);
        String username = user.getUsercode();
        String pass = user.getPassword();
        
        String returnMsg = tCCreateUser.createUser(username, pass);

        return returnMsg;
    }

    public String authenticateUser(UserDTO user) {
        
        log.info("Inside method authenticateUser of CreateUserService with inputs :: "+user);
        String username = user.getUsercode();
        String pass = user.getPassword();
        
        String returnMsg = tCCreateUser.authenticateUser(username, pass);

        return returnMsg;
    }
}
