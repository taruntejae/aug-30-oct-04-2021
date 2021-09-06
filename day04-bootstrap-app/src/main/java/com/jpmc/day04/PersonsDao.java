package com.jpmc.day04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PersonsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(int id, String name, int age) {
        jdbcTemplate.update("insert into persons values(?, ?, ?)", id, name, age);
    }
}
