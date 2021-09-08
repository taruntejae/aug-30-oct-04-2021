package com.jpmc.lab06.service;

import com.jpmc.lab06.domain.Topic;
import com.jpmc.lab06.repo.TopicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceService {
    @Autowired
    private TopicDao topicDao;
    public boolean addTopic(String title, int duration) {
        topicDao.addTopic(title, duration);
        return true;
    }
    public List<Topic> getAllTopics() {
        return topicDao.getTopics();
    }
}
