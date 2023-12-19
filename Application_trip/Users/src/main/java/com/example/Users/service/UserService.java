package com.example.Users.service;

import com.example.Users.client.DataUser;
import com.example.Users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private DataUser client;

    public List<User> getAllUsers() {
        return client.findAll();
    }

    public   Optional<User> getUserById(long id) {
        return client.findById(id);
    }


    public   void deleteUser(long id) {
        client.deleteById(id);
    }

    public   User createUser(User User) {
        return client.save(User);
    }

    public User findByUsername(String username) {
        return client.findByUsername(username);
    }

    public User updtaeUser(User User) {
        return client.updateUser(User);
    }
}