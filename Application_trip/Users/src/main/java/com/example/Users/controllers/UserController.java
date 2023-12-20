package com.example.Users.controllers;

import com.example.Users.model.User;
import com.example.Users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService tripService;


    @GetMapping
    public List<User> getAllUsers() {
        return tripService.getAllUsers();
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        return tripService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public User createTrip(@RequestBody User trip) {
        return tripService.createUser(trip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User trip) {
        if (tripService.getUserById(id).isPresent()) {
            trip.setId(id);
            return ResponseEntity.ok(tripService.createUser(trip));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        tripService.deleteUser(id);
    }
}

