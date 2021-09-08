package com.jpmc.day05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Day05OrmAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Day05OrmAppApplication.class, args);
    }

    @Autowired
    private PersonsDao personsDao;

    @Override
    public void run(String... args) throws Exception {

        //savePerson();
        //updateAge();
        //personsDao.deleteById(101);



        Iterator<Person> itr = personsDao.findAll().iterator();
        List<Person> persons = new ArrayList<>();
        while(itr.hasNext()) {
            persons.add(itr.next());
        }
        System.out.println(persons);

        System.out.println("Done");

    }

    private void updateAge() {
//        Optional<Person> optPerson101 = personsDao.findById(101);
//        optPerson101.get();
        Optional<Person> optPerson = personsDao.findById(101);
        if(optPerson.isPresent()) {
            Person person = optPerson.get();
            person.setAge(77);
            personsDao.save(person);
        } else {
            System.out.println("Person with id 101 is not found");
        }
    }

    private void savePerson() {
        Person p1 = new Person();
        p1.setId((int)(Math.random() * 10000));
        p1.setName("Vikasa");
        p1.setAge(56);
        personsDao.save(p1);
    }
}
