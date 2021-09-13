package com.jpmc.day06ormapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day06OrmAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Day06OrmAppApplication.class, args);
    }

    @Autowired
    private PersonService personService;

    @Override
    public void run(String... args) throws Exception {
        personService.savePersons((int)(Math.random() * 1000), "Sharma", 34);
    }
}
