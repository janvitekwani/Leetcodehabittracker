package com.example.leetcodehabitfinal.config;

import com.example.leetcodehabitfinal.entity.Topic;
import com.example.leetcodehabitfinal.repository.TopicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
 class DataInitializer {
    @Bean
    public CommandLineRunner initTopics(TopicRepository topicRepository) {
        return args -> {
            if (topicRepository.count() == 0) {
                List<Topic> topics = Arrays.asList(
                        // Month 1 Topics
                        createTopic("Arrays", 5, "Month1", "Two Pointers, Sorting, Kadane's Algorithm, Array Rotations, Subarrays"),
                        createTopic("Linked List", 4, "Month1", "Nodes Manipulation, Reversing, Reordering, Manipulating Two Lists"),
                        createTopic("Sorting", 4, "Month1", "Merge Sort, Quick Sort, Inversion count"),
                        createTopic("Stacks", 3, "Month1", "Implementation, Infix/Prefix/Postfix, Previous smaller element, Window-based"),
                        createTopic("Queues", 3, "Month1", "Queue using Stack, Sliding window-based"),
                        createTopic("Backtracking", 3, "Month1", "Knights' Tour, Rat in a Maze, N-Queen"),
                        createTopic("Recursion", 2, "Month1", "nCr, Josephus, Generating Palindrome Strings, Subsets"),

                        // Month 2 Topics
                        createTopic("Hashing", 5, "Month2", "Substring/subarray hashing, String/Matrix hashing"),
                        createTopic("Binary Searching", 4, "Month2", "Sorted/rotated arrays, square root, median, Tree Cutter"),
                        createTopic("Binary Tree", 4, "Month2", "DFS Traversal, BFS Traversal, Upward Traversal"),
                        createTopic("Binary Search Trees", 4, "Month2", "BST Implementation, Two-sum, Minimum Absolute Difference"),
                        createTopic("Priority Queue", 2, "Month2", "Heap, Merge k-sorted Lists, Median of stream"),
                        createTopic("Bit Manipulation", 2, "Month2", "Bit masking, XOR properties"),
                        createTopic("Mathematics", 2, "Month2", "Euclid GCD, Modulo Arithmetics, Catalan's Numbers"),

                        // Month 3 Topics
                        createTopic("Mock Tests", 5, "Month3", "Company wise tests, Coding contests"),
                        createTopic("Greedy Programming", 4, "Month3", "Candy Distribution, Activity Selection"),
                        createTopic("Dynamic Programming", 4, "Month3", "Linear DP, LCS, LIS, 0/1 Knapsack, Grid-based, Partitioning"),
                        createTopic("Graphs", 3, "Month3", "Grid-based, BFS/DFS, Capture region, Water flow"),
                        createTopic("Disjoint Sets", 2, "Month3", "Path compression, Rank"),
                        createTopic("Trie", 2, "Month3", "Implementation, n Strings, Common prefix"),
                        createTopic("Segment Trees", 2, "Month3", "Basic Implementation, N-Ary Rooted Tree"),
                        createTopic("String Algorithms", 1, "Month3", "KMP Algorithm, Rabin Karp")
                );

                topicRepository.saveAll(topics);
            }
        };
    }

    private Topic createTopic(String name, int rating, String month, String patterns) {
        Topic topic = new Topic();
        topic.setName(name);
        topic.setRating(rating);
        topic.setMonth(month);
        topic.setPatterns(patterns);
        return topic;
    }
}
