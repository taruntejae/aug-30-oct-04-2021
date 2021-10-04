package com.jpmc.day15cachingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Day15CachingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day15CachingAppApplication.class, args);
    }

}
