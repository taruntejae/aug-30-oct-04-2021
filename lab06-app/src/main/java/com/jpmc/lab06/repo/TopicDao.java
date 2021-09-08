package com.jpmc.lab06.repo;

import com.jpmc.lab06.domain.Topic;

import java.util.List;

public interface TopicDao {
    void addTopic(String title, int duration);
    List<Topic> getTopics();
    boolean topicExists(String title);
}
