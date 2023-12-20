package com.example.Users.controllers;

import com.example.Users.model.User;
import com.example.Users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // Fetch user details from the database
        User user = userService.findByUsername(loginRequest.getUsername());

        // Check if the user exists and the password is correct
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            return "Authentication successful";
        } else {
            return "Invalid credentials";
        }
    }
    @PostMapping("/signup")
    public User createTrip(@RequestBody User user) {
        return userService.createUser(user);
    }
}
