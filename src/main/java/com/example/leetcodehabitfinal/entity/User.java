package com.example.leetcodehabitfinal.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the user

    @Column(nullable = false, unique = true)
    private String username; // Unique username for the user

    @Column(nullable = false)
    private String password; // Encrypted password for the user

    @Column(nullable = false, unique = true)
    private String email; // Unique email address for the user

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserGoal userGoal; // The user's learning goals

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DailyProgress> dailyProgresses = new HashSet<>(); // Set of daily progress records for the user
}
