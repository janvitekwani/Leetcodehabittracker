package com.example.leetcodehabitfinal.Controller;

import com.example.leetcodehabitfinal.DTO.UserGoalDTO;
import com.example.leetcodehabitfinal.Service.UserGoalService;
import com.example.leetcodehabitfinal.entity.UserGoal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/goals")
public class UserGoalController {
    private final UserGoalService userGoalService;

    /**
     * Constructor to inject the UserGoalService dependency.
     *
     * @param userGoalService Service layer to handle business logic for user goals.
     */
    @Autowired
    public UserGoalController(UserGoalService userGoalService) {
        this.userGoalService = userGoalService;
    }

    /**
     * Endpoint to set a user's goal based on the provided goal data.
     * Expects a POST request with a UserGoalDTO in the request body.
     *
     * @param goalDTO Data transfer object containing the user's goal information.
     * @return ResponseEntity containing the created UserGoal object.
     */
    @PostMapping
    public ResponseEntity<UserGoal> setUserGoal(@RequestBody UserGoalDTO goalDTO) {
        // Delegate the task of setting the user goal to the service layer
        UserGoal userGoal = userGoalService.setUserGoal(goalDTO);
        // Return the created user goal wrapped in a ResponseEntity
        return ResponseEntity.ok(userGoal);
    }
}
