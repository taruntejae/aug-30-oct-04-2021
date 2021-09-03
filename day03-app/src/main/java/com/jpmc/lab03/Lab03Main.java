package com.jpmc.lab03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab03Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("lab03-beans.xml");
        Company company = context.getBean("company", Company.class);
        System.out.println(company.getName());
        System.out.println(company.getLocation());
        System.out.println(company.getEmployees());
        System.out.println(company.getCeo());

        System.out.println(company);
    }
}
