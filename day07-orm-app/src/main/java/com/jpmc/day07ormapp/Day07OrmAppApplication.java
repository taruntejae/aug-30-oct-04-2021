package com.jpmc.day07ormapp;

import com.jpmc.day07ormapp.service.AccountService;
import com.jpmc.day07ormapp.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day07OrmAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Day07OrmAppApplication.class, args);
    }

    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... args) throws Exception {
        accountService.withdraw("acc101", 300000);
    }
}
