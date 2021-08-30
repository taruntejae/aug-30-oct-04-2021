package com.jpmc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class PersonUser {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
        Person person = (Person)context.getBean("person2");
        System.out.println(person.getName());
        person.driveToWork();


        // Unnecessary creation code
//        Person sam = new Person();
//        sam.setName("Sam");
//
//        Car bmw = new Car();
//        bmw.setModel("BMW");
//        bmw.setYearOfMake(2020);
//        sam.setCar(bmw);
//
//        sam.driveToWork();
    }
}
