package com.example.leetcodehabitfinal.Service;

import com.example.leetcodehabitfinal.entity.Topic;
import com.example.leetcodehabitfinal.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    private final TopicRepository topicRepository;  // Inject the TopicRepository to interact with the database

    // Constructor-based dependency injection for the TopicRepository
    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    // Method to get all topics from the database
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();  // Retrieves all topics from the repository
    }

    // Method to get topics by month
    public List<Topic> getTopicsByMonth(String month) {
        return topicRepository.findByMonth(month);  // Retrieves topics filtered by the given month
    }

    // Method to create a new topic in the database
    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);  // Saves the new topic to the repository
    }
}
