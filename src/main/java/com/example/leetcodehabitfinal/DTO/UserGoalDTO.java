package com.example.leetcodehabitfinal.DTO;

import lombok.Data;

@Data
public class UserGoalDTO {
    private Long userId;
    private String preparationLevel;
    private Integer dailyMinHours;
    private Integer dailyMinScore;
    private Integer readinessPercentage;
}
