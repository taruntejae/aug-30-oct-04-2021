package com.jpmc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Lifecycle {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans-lifecycle.xml");
        Company company1 = context.getBean("company", Company.class); // (Company)context.getBean("company");
        System.out.println(company1);
        Company company2 = context.getBean("company", Company.class); // (Company)context.getBean("company");
        System.out.println(company2);
        Company company3 = context.getBean("company", Company.class); // (Company)context.getBean("company");
        System.out.println(company3);

        Country india = context.getBean("country", Country.class);
        System.out.println(india.getCityNames());

        Country aus = context.getBean("country", Country.class);

    }
}
