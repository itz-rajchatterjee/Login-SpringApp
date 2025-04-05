package com.persistance.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.persistance.dto.UserDTO;
import com.persistance.service.CreateUserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private CreateUserService createUserService;

    @PostMapping("/login")
    public String login(@RequestBody UserDTO user) {
        String response = null;
        response = createUserService.authenticateUser(user);
        return response;
    }

    @PostMapping("/create-user")
    public String createUser(@RequestBody UserDTO user) {
        String response = null;
        response = createUserService.createUser(user);
        return response;
    }
}
