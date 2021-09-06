package com.jpmc.day04.lab05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Ceo {
    @Value("${ceo.name}")
    private String name;
    @Value("${ceo.age}")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Ceo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}