package com.jpmc.day15aopapp;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void work() {
        System.out.println(name + " is sleeping; checking mails and on FB");
    }
}
