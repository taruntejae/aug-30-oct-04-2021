package com.jpmc.day06ormapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public void savePersons(int id, String name, int age) {
        Person person = new Person(id, name, age);
        personRepository.save(person);
    }
}
