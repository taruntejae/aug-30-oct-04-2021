package com.friday.jpmc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class JdbcMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        PersonsDao personsDao = context.getBean("personsDao", PersonsDao.class);
        List<String> csv = personsDao.getAllPersonsInCSV();
        for (String item: csv) {
            System.out.println(item);
        }


        try {
            personsDao.updateAge(101, 12);
        } catch(DataAccessException ex) {
            System.out.println(ex.getCause().getMessage());
        }
        List<Person> persons = personsDao.getAllPersons();
        for (Person person : persons ) {
            System.out.println(person);
        }

        //personsDao.insertPerson(104, "Ram", 23);
        //System.out.println("Inserted");
//        personsDao.deletePerson(104);
//        System.out.println("Deleted");
        List<String> names = personsDao.getAllNames();
        System.out.println(names);
    }
}
