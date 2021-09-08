package com.jpmc.day05;

import org.springframework.data.repository.CrudRepository;

public interface PersonsDao extends CrudRepository<Person, Integer> {
}
