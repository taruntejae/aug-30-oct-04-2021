package com.jpmc.lab13app.controller;

import com.jpmc.lab13app.entity.Person;
import com.jpmc.lab13app.exception.PersonNotFoundException;
import com.jpmc.lab13app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPersons();
    }

    @PostMapping
    public String createPerson(@RequestBody Person person) {
        personService.savePerson(person);
        return "Person saved successfully";
    }

    @PatchMapping("/id/{id}/age/{age}")
    public String updateAgeOfPerson(@PathVariable int id, @PathVariable int age) throws PersonNotFoundException {
        personService.updateAge(id, age);
        return "Age updated";
    }

    @DeleteMapping("/id/{id}")
    public String removePerson(@PathVariable int id) throws PersonNotFoundException {
        personService.delete(id);
        return  "Person deleted";
    }

    @GetMapping("/age/gt/{age}")
    public List<Person> getPersonsWithAgeGt(@PathVariable int age) {
        List<Person> persons = personService.getAllPersonsWithAgeGt(age);
        return persons;
    }

}
