package com.example.leetcodehabitfinal.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_goals")
@Data
public class UserGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the user goal

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Reference to the user associated with these goals

    @Column(nullable = false)
    private String preparationLevel; // The user's preparation level (e.g., "Basic", "Serious", "Insane")

    @Column(nullable = false)
    private Integer dailyMinHours; // Minimum number of hours the user aims to study daily

    @Column(nullable = false)
    private Integer dailyMinScore; // Minimum score the user aims to achieve daily

    @Column(nullable = false)
    private Integer readinessPercentage; // Percentage indicating the user's readiness level
}
