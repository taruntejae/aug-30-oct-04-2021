package com.jpmc.day06ormapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Day06OrmAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Day06OrmAppApplication.class, args);
    }

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        //savePersonWithOneCar();
        Optional<Person> optPerson = personRepository.findById(685);
        if(optPerson.isPresent()) {
            Person person = optPerson.get();
            System.out.println(person);
            List<Car> cars =  person.getCars();
            System.out.println(cars);
        }




        //personService.savePersons((int)(Math.random() * 1000), "Sharma", 34);
        //Person person = personService.getPersonWithAge(34);
//        Person person = personService.getPersonWithNameAndAge("Ram", 34);
//        if(person != null) {
//            System.out.println(person);
//        }
////        List<Person> persons = personService.getAllPersons();
////        System.out.println(persons);
//
//        List<Person> persons = personService.getAllPersonsWithAgeBetween(30, 60);
//        System.out.println(persons);
//        System.out.println();
//        Optional<Integer> optAge = personService.getAgeOfPersonWithId(558);
//        if(optAge.isPresent()) {
//            System.out.println("Age: " + optAge.get());
//        } else {
//            System.out.println("Person not found");
//        }


    }

    private void savePersonWithOneCar() {
        Person p1 = new Person((int)(Math.random() * 1000), "Ram", 23);
        Car c1 = new Car((int)(Math.random() * 1000), "Santro", 2020);

        List<Car> cars = new ArrayList<>();
        cars.add(c1);
        p1.setCars(cars);

        c1.setOwner(p1);
        personRepository.save(p1);
        System.out.println("Done");
    }
}
