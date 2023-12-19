package com.MysqlService.MysqlService.service;


import com.MysqlService.MysqlService.model.User;
import com.MysqlService.MysqlService.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll(); // Assuming you have a findAllUsers method in your client
    }
    public User saveUser(User trip) {
        return userRepository.save(trip);
    }
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User updateUser(User updatedUser) {
        return userRepository.findById(updatedUser.getId())
                .map(existingUser -> {
                    existingUser.setFirstname(updatedUser.getFirstname());
                    existingUser.setLastname(updatedUser.getLastname());
                    existingUser.setUsername(updatedUser.getUsername());
                    existingUser.setPassword(updatedUser.getPassword());
                    return userRepository.save(existingUser);
                })
                .orElse(null);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
