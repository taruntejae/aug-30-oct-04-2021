package com.jpmc.lab12app.controller;

import com.jpmc.lab12app.exception.AccountNotFoundException;
import com.jpmc.lab12app.exception.InsufficientBalanceException;
import com.jpmc.lab12app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/deposit")
    public String deposit(@RequestParam("accountnumber") String accountNumber, @RequestParam int amount) {
        String result = "Deposit success";
        try {
            accountService.deposit(accountNumber, amount);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            result = "Deposit failed. " + e.getMessage();
        }
        return result;
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam("accountnumber") String accountNumber, @RequestParam int amount) {
        String result = "Withdraw success";
        try {
            accountService.withdraw(accountNumber, amount);
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            e.printStackTrace();
            result = "Withdraw failed. " + e.getMessage();
        }
        return result;
    }
}
