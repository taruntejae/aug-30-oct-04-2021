package com.jpmc.lab13app.service;

import com.jpmc.lab13app.entity.Person;
import com.jpmc.lab13app.exception.PersonNotFoundException;
import com.jpmc.lab13app.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAllPersons();
    }

    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public void updateAge(int id, int age) throws PersonNotFoundException {
        Optional<Person> optPerson = personRepository.findById(id);
        if(optPerson.isPresent()) {
            Person person = optPerson.get();
            person.setAge(age);
            personRepository.save(person);
        } else {
            throw new PersonNotFoundException(id);
        }
    }

    public void delete(int id) throws PersonNotFoundException {
        Optional<Person> optPerson = personRepository.findById(id);
        if(optPerson.isPresent()) {
            Person person = optPerson.get();
            personRepository.delete(person);
        } else {
            throw new PersonNotFoundException(id);
        }
    }

    public List<Person> getAllPersonsWithAgeGt(int age) {
        return personRepository.findAllByAgeGreaterThan(age);
    }
}
