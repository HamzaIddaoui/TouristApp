package com.example.Users.client;

import com.example.Users.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Data-service-TRIP",  url = "${application.config.Datas-url}")
public interface DataUser {

    @DeleteMapping("/user/delete/{id}")
    void deleteById(@PathVariable("id") long id);

    @PostMapping("/user/Add")
    User save(@RequestBody User user);

    @GetMapping("/user/{id}")
    Optional<User> findById(@PathVariable("id") long id);

    @GetMapping("/user/All")
    List<User> findAll();

    @GetMapping("/user/{username}")
    User findByUsername(@PathVariable("username") String username);
    @DeleteMapping("/user/delete/{id}")
    void deleteUser(@PathVariable("id") long id);
    @PutMapping("/user/update")
    User updateUser(User updatedUser);
}
