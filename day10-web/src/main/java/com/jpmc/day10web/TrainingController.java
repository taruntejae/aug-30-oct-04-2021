package com.jpmc.day10web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class TrainingController {

    @GetMapping("/training1/info")
    public Training getInfo() {
        Training training = new Training();
        training.setName("Spring boot");
        training.setDuration(60);
        training.setTopics(Arrays.asList("Web", "ORM", "Microservices"));
        return training;
    }

    @PostMapping("/training1/data")
    public String submitTrainingData(@RequestBody Training training) {
        System.out.println(training);
        return "Thanks";
    }
}
