package com.example.leetcodehabitfinal.repository;

import com.example.leetcodehabitfinal.entity.User;
import com.example.leetcodehabitfinal.entity.UserGoal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserGoalRepository extends JpaRepository<UserGoal, Long> {
    Optional<UserGoal> findByUser(User user);  // find the user by id
}
