package com.example.leetcodehabitfinal.repository;




import com.example.leetcodehabitfinal.entity.DailyProgress;
import com.example.leetcodehabitfinal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
public interface DailyProgressRepository extends JpaRepository<DailyProgress, Long> {
    List<DailyProgress> findByUserAndDateBetween(User user, LocalDate startDate, LocalDate endDate); // find by user and date between
    Optional<DailyProgress> findByUserAndDate(User user, LocalDate date);  //  find user and date
    List<DailyProgress> findByUser(User user);  // find user
}
