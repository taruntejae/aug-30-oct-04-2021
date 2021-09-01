package com.jpmc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsingAnnotationMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-using-annot.xml");
        Car car = context.getBean("car", Car.class);
        System.out.println(car.getModel());
        System.out.println(car.getYearOfMake());
        System.out.println(car.getEngine());
    }
}
