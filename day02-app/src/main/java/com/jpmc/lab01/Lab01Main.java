package com.jpmc.lab01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Lab01Main {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:lab01-beans.xml");
        Conference conference = context.getBean("conference", Conference.class);
        System.out.println(String.format("45min: %d, 50min: %d, 60min: %d", conference.getTotalNumberOf45MinTopics(), conference.getTotalNumberOf50MinTopics(), conference.getTotalNumberOf60MinTopics()));
    }
}
