package com.friday.jpmc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PersonsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertPerson(int id, String name, int age) {
        String query = "insert into persons values(?, ?, ?)";
        jdbcTemplate.update(query, id, name, age);
    }

    public void deletePerson(int id) {
        String query = "delete from persons where id = ?";
        jdbcTemplate.update(query, id);
    }
}
