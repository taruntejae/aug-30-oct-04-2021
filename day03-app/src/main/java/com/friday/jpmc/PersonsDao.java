package com.friday.jpmc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class PersonsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> getAllPersonsInCSV() {
        String query = "select * from persons";
        PersonCSVRowMapper csvMapper = new PersonCSVRowMapper();
        List<String> csvList = jdbcTemplate.query(query, csvMapper);
        return csvList;
    }

    public List<Person> getAllPersons() {
        String query = "select * from persons";
        return jdbcTemplate.query(query, new PersonRowMapper());
    }

    public void updateAge(int id, int age) {
        String query = "updat persons p set p.age = ? where p.id = ?";
        jdbcTemplate.update(query, age, id);
    }

    public List<String> getAllNames() {
        return jdbcTemplate.queryForList("select name from persons", String.class);
    }

    public void insertPerson(int id, String name, int age) {
        String query = "insert into persons values(?, ?, ?)";
        jdbcTemplate.update(query, id, name, age);
    }

    public void deletePerson(int id) {
        String query = "delete from persons where id = ?";
        jdbcTemplate.update(query, id);
    }
}

class PersonCSVRowMapper implements RowMapper<String> {

    @Override
    public String mapRow(ResultSet resultSet, int i) throws SQLException {
        String csv = "";
        csv += resultSet.getInt("id") + ",";
        csv += resultSet.getString("name") + ",";
        csv += resultSet.getInt("age");

        return csv;
    }
}

class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setAge(resultSet.getInt("age"));
        return person;
    }
}