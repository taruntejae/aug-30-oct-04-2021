package com.jpmc.day04.lab05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class Lab05Configuration {
    @Bean
    public Set<Employee> employees() {
        Set<Employee> employees = new HashSet<>();
        Employee e1 = new Employee();
        e1.setId(101);
        e1.setName("Ram");
        e1.setLevel(2);
        Employee e2 = new Employee();
        e2.setId(102);
        e2.setName("Sam");
        e2.setLevel(4);
        employees.add(e1);
        employees.add(e2);
        return employees;
    }
}
