package com.jpmc.day06ormapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Day06OrmAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Day06OrmAppApplication.class, args);
    }

    @Autowired
    private PersonService personService;

    @Override
    public void run(String... args) throws Exception {
        //personService.savePersons((int)(Math.random() * 1000), "Sharma", 34);
        //Person person = personService.getPersonWithAge(34);
        Person person = personService.getPersonWithNameAndAge("Ram", 34);
        if(person != null) {
            System.out.println(person);
        }
//        List<Person> persons = personService.getAllPersons();
//        System.out.println(persons);

        List<Person> persons = personService.getAllPersonsWithAgeBetween(30, 60);
        System.out.println(persons);
        System.out.println();
        Optional<Integer> optAge = personService.getAgeOfPersonWithId(558);
        if(optAge.isPresent()) {
            System.out.println("Age: " + optAge.get());
        } else {
            System.out.println("Person not found");
        }


    }
}
