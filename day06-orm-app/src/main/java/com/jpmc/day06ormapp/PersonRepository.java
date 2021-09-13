package com.jpmc.day06ormapp;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    //findBy, findAllBy

    @Query(value = "select age from persons where id = :p1", nativeQuery = true)
    Optional<Integer> findAgeById(@Param("p1") int id);
    Person findByName(String name);
    Person findByAge(int age); //select * from persons where age = ?
    Person findByNameAndAge(String name, int age);
    Person findByIdAndNameAndAge(int id, String name, int age);
    Person findByNameOrAge(String name, int age);

    List<Person> findAll();
    List<Person> findAllByName(String name);
    List<Person> findAllByAge(int age);
    List<Person> findAllByNameAndAge(String name, int age);
    List<Person> findAllByNameOrAge(String name, int age);

    List<Person> findAllByNameInAndAgeIn(List<String> names, List<Integer> ages);
    List<Person> findAllByAgeBetween(int from, int to);
    List<Person> findAllByAgeGreaterThan(int age);

    @Query("select p from Person p where p.age between :p1 and :p2") //JPA QL
    List<Person> getAllPersonsInAgeRange(@Param("p1") int fromAge, @Param("p2") int toAge);

    @Modifying
    @Query("update Person p set p.age = :p1 where p.id = :p2")
    void updateAgeOfPerson(@Param("p2") int id, @Param("p1") int age);

    @Query(value = "select distinct name from persons", nativeQuery = true)
    List<String> getAllDistinctPersonNames();

    @Query(value = "select * from persons", nativeQuery = true)
    List<Person> getAll();
}
