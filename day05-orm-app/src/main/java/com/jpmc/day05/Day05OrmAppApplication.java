package com.jpmc.day05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day05OrmAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Day05OrmAppApplication.class, args);
    }

    @Autowired
    private PersonsDao personsDao;

    @Override
    public void run(String... args) throws Exception {
        Person p1 = new Person();
        p1.setId((int)(Math.random() * 10000));
        p1.setName("Vikasa");
        p1.setAge(56);
        personsDao.save(p1);
        System.out.println("Done");

    }
}
