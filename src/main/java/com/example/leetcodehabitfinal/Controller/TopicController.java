package com.example.leetcodehabitfinal.Controller;

import com.example.leetcodehabitfinal.Service.TopicService;
import com.example.leetcodehabitfinal.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicController {
    private final TopicService topicService;

    // Constructor injection for TopicService
    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    /**
     * Endpoint to retrieve all topics.
     *
     * @return ResponseEntity containing a list of all topics.
     */
    @GetMapping
    public ResponseEntity<List<Topic>> getAllTopics() {
        return ResponseEntity.ok(topicService.getAllTopics());
    }

    /**
     * Endpoint to retrieve topics by month.
     *
     * @param month - The month to filter topics.
     * @return ResponseEntity containing a list of topics for the given month.
     */
    @GetMapping("/month/{month}")
    public ResponseEntity<List<Topic>> getTopicsByMonth(@PathVariable String month) {
        return ResponseEntity.ok(topicService.getTopicsByMonth(month));
    }

    /**
     * Endpoint to create a new topic.
     *
     * @param topic - The topic to be created.
     * @return ResponseEntity containing the created topic.
     */
    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic) {
        return ResponseEntity.ok(topicService.createTopic(topic));
    }
}
