package com.example.fypms.controller;

import com.example.fypms.model.User;
import com.example.fypms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // Register new user
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        // For now, store password as is (no hashing yet)
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    // Login user
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Optional<User> foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser.isEmpty()) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }

        if (!foundUser.get().getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }

        return ResponseEntity.ok("Login successful");
    }
}
