package com.jpmc.lab02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab02Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("lab02-beans.xml");
        Conference conference = context.getBean("conference", Conference.class);
        System.out.println(String.format("45min: %d, 50min: %d, 60min: %d", conference.getTotalNumberOf45MinTopics(), conference.getTotalNumberOf50MinTopics(), conference.getTotalNumberOf60MinTopics()));
    }
}
