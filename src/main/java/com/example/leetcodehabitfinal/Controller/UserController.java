package com.example.leetcodehabitfinal.Controller;





import com.example.leetcodehabitfinal.DTO.DailyProgressDTO;
import com.example.leetcodehabitfinal.DTO.UserDTO;

import com.example.leetcodehabitfinal.Service.UserService;
import com.example.leetcodehabitfinal.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    // Constructor injection for UserService
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Endpoint to register a new user.
     *
     * @param userDTO - The data transfer object containing user details.
     * @return ResponseEntity containing the created user.
     */
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDTO userDTO) {
        User user = userService.registerUser(userDTO);
        return ResponseEntity.ok(user);
    }
}