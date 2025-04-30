package com.example.leetcodehabitfinal.entity;

import com.example.leetcodehabitfinal.entity.Topic;
import com.example.leetcodehabitfinal.entity.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "daily_progress")
@Data
public class DailyProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the daily progress record

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Reference to the user associated with this progress

    @Column(nullable = false)
    private LocalDate date; // Date of the recorded progress

    @Column(nullable = false)
    private Integer hoursSpent; // Number of hours spent on learning

    @Column(nullable = false)
    private Integer scoreEarned; // Score achieved by the user

    @Column(nullable = false)
    private Boolean targetAchieved; // Indicates if the daily learning target was met

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic; // Reference to the topic covered on this day

    @Column
    private String notes; // Additional notes or comments about the day's progress
}