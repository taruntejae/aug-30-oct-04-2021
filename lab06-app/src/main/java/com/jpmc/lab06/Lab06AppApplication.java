package com.jpmc.lab06;

import com.jpmc.lab06.domain.Topic;
import com.jpmc.lab06.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Lab06AppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Lab06AppApplication.class, args);
    }

    @Autowired
    private ConferenceService conferenceService;

    @Override
    public void run(String... args) throws Exception {
        conferenceService.addTopic("RoR", 60);
        conferenceService.addTopic("Scala", 50);
        conferenceService.addTopic("JavaScript hacks", 45);

        List<Topic> topics = conferenceService.getAllTopics();
        for (Topic topic: topics) {
            System.out.println(topic);
        }
    }
}
