package com.example.leetcodehabitfinal.Service;

import com.example.leetcodehabitfinal.DTO.UserDTO;
import com.example.leetcodehabitfinal.entity.User;
import com.example.leetcodehabitfinal.exceptions.ResourceNotFoundException;
import com.example.leetcodehabitfinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;  // Repository for user data
    private final PasswordEncoder passwordEncoder;  // Password encoder for secure password storage

    // Constructor-based dependency injection for UserRepository and PasswordEncoder
    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Method to register a new user using the provided user DTO (data transfer object)
    public User registerUser(UserDTO userDTO) {
        // Create a new user entity and set its attributes from the DTO
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));  // Securely encode the user's password

        // Save and return the newly registered user
        return userRepository.save(user);
    }

    // Method to find a user by their username
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);  // Retrieves the user based on the username
    }
}