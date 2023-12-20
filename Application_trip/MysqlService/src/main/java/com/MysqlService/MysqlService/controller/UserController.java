package com.MysqlService.MysqlService.controller;


import com.MysqlService.MysqlService.model.User;
import com.MysqlService.MysqlService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/All")
    public List<User> getAll() {
        return userService.getAllUsers();
    }
    @PostMapping("/user/Add")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    @GetMapping("/user/{username}")
    public Optional<User> findByUsername(@PathVariable("username") String username){
        return userService.findByUsername(username);
    }

    @DeleteMapping("/user/delete/{id}")
    public  void deleteUser(@PathVariable("id") long id) {
         userService.deleteUser(id);
    }

    @PutMapping("/user/update")
    public User updateUser(User updatedUser) {
        return userService.updateUser(updatedUser);
    }
}
