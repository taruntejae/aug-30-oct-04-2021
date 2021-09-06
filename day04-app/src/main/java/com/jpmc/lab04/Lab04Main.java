package com.jpmc.lab04;

import com.jpmc.lab04.exception.AccountNotFoundException;
import com.jpmc.lab04.exception.AccountOperationFailedException;
import com.jpmc.lab04.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab04Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("lab04-beans.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        try {
            accountService.deposit("acc101", 10000);
            accountService.withdraw("acc101", 1000000);
        }
        catch (AccountNotFoundException | AccountOperationFailedException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Done");
    }
}
