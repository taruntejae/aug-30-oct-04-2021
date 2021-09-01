package com.jpmc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class PlayingMoreWithCfg {
    public static void main(String[] args) {
        //ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
        //ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person.getName());
        System.out.println(person.getMessage());
        System.out.println("Shutting down...");
        context.close();
    }
}
