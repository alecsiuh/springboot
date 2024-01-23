package com.example.programming_project.service;

import com.example.programming_project.domain.User;
import com.example.programming_project.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User addUser(String username, String email, String password) {
        var user = new User(username, email, password);
        return userRepository.save(user);
    }

    public User getUserByName(String username) {
        return userRepository.findByUsername(username);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
