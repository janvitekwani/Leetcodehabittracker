package com.example.leetcodehabitfinal.Service;

import com.example.leetcodehabitfinal.DTO.DailyProgressDTO;
import com.example.leetcodehabitfinal.entity.DailyProgress;
import com.example.leetcodehabitfinal.entity.Topic;
import com.example.leetcodehabitfinal.entity.User;
import com.example.leetcodehabitfinal.entity.UserGoal;
import com.example.leetcodehabitfinal.repository.DailyProgressRepository;
import com.example.leetcodehabitfinal.repository.TopicRepository;
import com.example.leetcodehabitfinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DailyProgressService {
    private final DailyProgressRepository dailyProgressRepository;
    private final UserRepository userRepository;
    private final TopicRepository topicRepository;
    private final UserGoalService userGoalService;

    /**
     * Constructs a new DailyProgressService with the specified repositories and services.
     *
     * @param dailyProgressRepository Repository for daily progress records.
     * @param userRepository          Repository for user data.
     * @param topicRepository         Repository for topic data.
     * @param userGoalService         Service for user goal management.
     */
    @Autowired
    public DailyProgressService(DailyProgressRepository dailyProgressRepository,
                                UserRepository userRepository,
                                TopicRepository topicRepository,
                                UserGoalService userGoalService) {
        this.dailyProgressRepository = dailyProgressRepository;
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
        this.userGoalService = userGoalService;
    }

    /**
     * Records the daily progress of a user based on the provided DTO.
     * Validates user existence, topic existence (if provided), and user goals.
     * Calculates whether the user has achieved their daily target.
     *
     * @param progressDTO Data transfer object containing progress details.
     * @return The saved DailyProgress entity.
     * @throws RuntimeException if user, topic, or user goal is not found.
     */
    public DailyProgress recordDailyProgress(DailyProgressDTO progressDTO) {
        // Retrieve user by ID and handle potential absence
        User user = userRepository.findById(progressDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Retrieve topic by ID if provided, otherwise set to null
        Topic topic = null;
        if (progressDTO.getTopicId() != null) {
            topic = topicRepository.findById(progressDTO.getTopicId())
                    .orElseThrow(() -> new RuntimeException("Topic not found"));
        }

        // Retrieve user goal and handle potential absence
        UserGoal userGoal = userGoalService.getUserGoalByUser(user)
                .orElseThrow(() -> new RuntimeException("User goal not set"));

        // Determine if the user has achieved their daily target
        boolean targetAchieved = progressDTO.getHoursSpent() >= userGoal.getDailyMinHours() &&
                progressDTO.getScoreEarned() >= userGoal.getDailyMinScore();

        // Create and populate the DailyProgress entity
        DailyProgress progress = new DailyProgress();
        progress.setUser(user);
        progress.setDate(progressDTO.getDate());
        progress.setHoursSpent(progressDTO.getHoursSpent());
        progress.setScoreEarned(progressDTO.getScoreEarned());
        progress.setTargetAchieved(targetAchieved);
        progress.setTopic(topic);
        progress.setNotes(progressDTO.getNotes());

        // Save and return the DailyProgress entity
        return dailyProgressRepository.save(progress);
    }

    /**
     * Retrieves the daily progress records of a user within a specified date range.
     *
     * @param userId    The ID of the user whose progress records are to be retrieved.
     * @param startDate The start date of the range.
     * @param endDate   The end date of the range.
     * @return A list of DailyProgress entities matching the criteria.
     * @throws RuntimeException if the user is not found.
     */
    public List<DailyProgress> getUserProgress(Long userId, LocalDate startDate, LocalDate endDate) {
        // Retrieve user by ID and handle potential absence
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Retrieve and return the list of daily progress records
        return dailyProgressRepository.findByUserAndDateBetween(user, startDate, endDate);
    }

    /**
     * Retrieves a specific day's progress record for a user.
     *
     * @param userId The ID of the user.
     * @param date   The date of the progress record.
     * @return An Optional containing the DailyProgress entity, or empty if not found.
     * @throws RuntimeException if the user is not found.
     */
    public Optional<DailyProgress> getDailyProgress(Long userId, LocalDate date) {
        // Retrieve user by ID and handle potential absence
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Retrieve and return the daily progress record
        return dailyProgressRepository.findByUserAndDate(user, date);
    }
}
