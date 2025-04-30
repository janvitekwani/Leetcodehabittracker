package com.example.leetcodehabitfinal.Service;

import com.example.leetcodehabitfinal.DTO.UserGoalDTO;
import com.example.leetcodehabitfinal.entity.User;
import com.example.leetcodehabitfinal.entity.UserGoal;
import com.example.leetcodehabitfinal.repository.UserGoalRepository;
import com.example.leetcodehabitfinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserGoalService {
    private final UserGoalRepository userGoalRepository;  // Repository for user goals
    private final UserRepository userRepository;  // Repository for users

    // Constructor-based dependency injection for the UserGoalRepository and UserRepository
    @Autowired
    public UserGoalService(UserGoalRepository userGoalRepository, UserRepository userRepository) {
        this.userGoalRepository = userGoalRepository;
        this.userRepository = userRepository;
    }

    // Method to set the user's goal based on the provided goal data transfer object (DTO)
    public UserGoal setUserGoal(UserGoalDTO goalDTO) {
        // Fetch the user using the user ID from the goal DTO
        User user = userRepository.findById(goalDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Determine the daily requirements based on the user's preparation level
        int dailyMinHours = 0;
        int dailyMinScore = 0;
        int readinessPercentage = 0;

        // Switch case to assign goal attributes based on preparation level
        switch (goalDTO.getPreparationLevel().toLowerCase()) {
            case "basic":
                dailyMinHours = 1;
                dailyMinScore = 200;
                readinessPercentage = 70;
                break;
            case "serious":
                dailyMinHours = 3;
                dailyMinScore = 400;
                readinessPercentage = 95;
                break;
            case "insane":
                dailyMinHours = 5;
                dailyMinScore = 600;
                readinessPercentage = 99;
                break;
            default:
                throw new RuntimeException("Invalid preparation level");
        }

        // Create and set the user's goal object
        UserGoal userGoal = new UserGoal();
        userGoal.setUser(user);
        userGoal.setPreparationLevel(goalDTO.getPreparationLevel());
        userGoal.setDailyMinHours(dailyMinHours);
        userGoal.setDailyMinScore(dailyMinScore);
        userGoal.setReadinessPercentage(readinessPercentage);

        // Save and return the newly created user goal
        return userGoalRepository.save(userGoal);
    }

    // Method to retrieve a user's goal by their user object
    public Optional<UserGoal> getUserGoalByUser(User user) {
        return userGoalRepository.findByUser(user);  // Fetches the user goal associated with the user
    }
}
