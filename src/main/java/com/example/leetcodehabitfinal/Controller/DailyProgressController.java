package com.example.leetcodehabitfinal.Controller;


import com.example.leetcodehabitfinal.DTO.DailyProgressDTO;
import com.example.leetcodehabitfinal.Service.DailyProgressService;
import com.example.leetcodehabitfinal.entity.DailyProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/progress")
public class DailyProgressController {
    private final DailyProgressService dailyProgressService;

    // Constructor injection for the DailyProgressService
    @Autowired
    public DailyProgressController(DailyProgressService dailyProgressService) {
        this.dailyProgressService = dailyProgressService;
    }

    /**
     * Endpoint to record the daily progress of a user.
     *
     * @param progressDTO - The data transfer object containing progress details.
     * @return ResponseEntity containing the recorded progress.
     */
    @PostMapping
    public ResponseEntity<DailyProgress> recordProgress(@RequestBody DailyProgressDTO progressDTO) {
        return ResponseEntity.ok(dailyProgressService.recordDailyProgress(progressDTO));
    }

    /**
     * Endpoint to retrieve progress of a user within a date range.
     *
     * @param userId - The ID of the user.
     * @param startDate - The start date of the progress (optional).
     * @param endDate - The end date of the progress (optional).
     * @return ResponseEntity containing a list of DailyProgress objects.
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DailyProgress>> getUserProgress(
            @PathVariable Long userId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        // If no start date provided, set default to 7 days ago.
        if (startDate == null) {
            startDate = LocalDate.now().minusDays(7);
        }
        // If no end date provided, set default to today.
        if (endDate == null) {
            endDate = LocalDate.now();
        }

        return ResponseEntity.ok(dailyProgressService.getUserProgress(userId, startDate, endDate));
    }

    /**
     * Endpoint to retrieve the daily progress of a user on a specific date.
     *
     * @param userId - The ID of the user.
     * @param date - The specific date to fetch the progress for.
     * @return ResponseEntity containing the DailyProgress object if found.
     */
    @GetMapping("/user/{userId}/date/{date}")
    public ResponseEntity<DailyProgress> getDailyProgress(
            @PathVariable Long userId,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return dailyProgressService.getDailyProgress(userId, date)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}