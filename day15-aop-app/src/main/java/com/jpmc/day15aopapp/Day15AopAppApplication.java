package com.jpmc.day15aopapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day15AopAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Day15AopAppApplication.class, args);
    }

    @Autowired
    private Employee employee;

    @Override
    public void run(String... args) throws Exception {
        //Classes are generated and instantiated and are ready
        System.out.println(employee.getClass().getName());

        employee.setName("Sam");
        employee.work();

        employee.setName("Smitha");
        employee.work();
    }
}
