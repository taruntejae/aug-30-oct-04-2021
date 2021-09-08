package com.jpmc.day05.lab07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ConferenceService {

    @Autowired
    private TopicRepository topicRepository;

    public boolean addTopic(String title, int duration) {
        //Not handled duplication yet; We will discuss this on Monday
        Topic topic = new Topic();
        topic.setTitle(title);
        topic.setDuration(duration);
        topicRepository.save(topic);
        return true;
    }
    public List<Topic> getAllTopics() {
        //Code can be made simpler; Let's get rid of Iterator on Monday
        Iterator<Topic> itr = topicRepository.findAll().iterator();
        List<Topic> topics = new ArrayList<>();
        while(itr.hasNext()) {
            topics.add(itr.next());
        }
        return topics;
    }
}
