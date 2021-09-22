package com.jpmc.lab13app.repo;

import com.jpmc.lab13app.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    @Query("select p from Person p")
    List<Person> findAllPersons();
    List<Person> findAllByAgeGreaterThan(int age);
}
