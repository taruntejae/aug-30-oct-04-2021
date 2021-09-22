package com.jpmc.lab13app.controller;

import com.jpmc.lab13app.controller.util.ErrorInformation;
import com.jpmc.lab13app.entity.Person;
import com.jpmc.lab13app.exception.PersonNotFoundException;
import com.jpmc.lab13app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
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

//    @ExceptionHandler(PersonNotFoundException.class)
//    public String handlePersonNotFoundException(PersonNotFoundException ex, WebRequest webRequest) {
//        String errorMessage = "Person with id " + ex.getMessage() + " is not found";
//        return errorMessage;
//    }

//    @ExceptionHandler(PersonNotFoundException.class)
//    public ResponseEntity<String> handlePersonNotFoundException(PersonNotFoundException ex, WebRequest webRequest) {
//        String errorMessage = "Person with id " + ex.getMessage() + " is not found";
//        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
//    }

//    @ExceptionHandler(PersonNotFoundException.class)
//    public ResponseEntity<ErrorInformation> handlePersonNotFoundException(PersonNotFoundException ex, WebRequest webRequest) {
//        String errorMessage = "Person with id " + ex.getMessage() + " is not found";
//        ErrorInformation info = new ErrorInformation();
//        info.setMessage(errorMessage);
//        info.setTimestamp(LocalDateTime.now());
//        info.setPath(webRequest.getDescription(false));
//        return new ResponseEntity<>(info, HttpStatus.NOT_FOUND);
//    }

}
