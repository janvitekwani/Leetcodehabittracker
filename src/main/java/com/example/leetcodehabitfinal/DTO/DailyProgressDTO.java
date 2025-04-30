package com.example.leetcodehabitfinal.DTO;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyProgressDTO {
    private Long userId;
    private LocalDate date;
    private Integer hoursSpent;
    private Integer scoreEarned;
    private Boolean targetAchieved;
    private Long topicId;
    private String notes;
}