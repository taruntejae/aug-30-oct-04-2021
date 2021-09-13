package com.jpmc.day06ormapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public void savePersons(int id, String name, int age) {
        Person person = new Person(id, name, age);
        personRepository.save(person);
    }
    public Person getPersonWithAge(int age) {
        return personRepository.findByAge(age);
    }
    public Person getPersonWithNameAndAge(String name, int age) {
        return personRepository.findByNameAndAge(name, age);
    }
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
    public List<Person> getAllPersonsWithAgeBetween(int from, int to) {
        return personRepository.findAllByAgeBetween(from, to);
    }
    public Optional<Integer> getAgeOfPersonWithId(int id) {
        return personRepository.findAgeById(id);
    }
}
