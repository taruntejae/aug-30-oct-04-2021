package com.jpmc.day04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

//beans.xml
@Configuration
public class AppConfiguration {

    @Bean
    public List<String> myHobbies() {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Eating");
        hobbies.add("Sleeping");
        hobbies.add("FB");
        return hobbies;
    }

    @Bean
    public List<String> myHobbiesList() {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Eating more");
        hobbies.add("Sleeping more");
        hobbies.add("FB and Twitter");
        return hobbies;
    }
}
