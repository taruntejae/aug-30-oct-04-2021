package com.jpmc.day15cachingapp;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    @Cacheable(value = "message", key = "#name")
    public String computeMessage(String name) {
        System.out.println("*****Computing message for " + name);
        //Simulating a delay of 5 seconds
        try {
            Thread.sleep(5000);
        } catch(Exception ex) {}
        String message = "Hi " + name;
        return message;
    }

    @CacheEvict(value = "message", key = "#name")
    public String computeByeMessage(String name) {
        String message = "Bye " + name;
        return message;
    }

}
