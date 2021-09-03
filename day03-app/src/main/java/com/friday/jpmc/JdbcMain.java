package com.friday.jpmc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        PersonsDao personsDao = context.getBean("personsDao", PersonsDao.class);

        //personsDao.insertPerson(104, "Ram", 23);
        System.out.println("Inserted");
//        personsDao.deletePerson(104);
//        System.out.println("Deleted");
        List<String> names = personsDao.getAllNames();
        System.out.println(names);
    }
}
