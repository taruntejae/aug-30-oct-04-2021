package com.jpmc.accountserviceapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    private Logger logger = LoggerFactory.getLogger(AccountController.class);

    @PostMapping("/deposit/{accountNumber}/{amount}")
    public String deposit(@PathVariable String accountNumber, @PathVariable int amount) {
        String result = "Deposit success";
        try {
            accountService.deposit(accountNumber, amount);

        } catch (AccountNotFoundException e) {
            logger.error("Error depositing amount, {}", e.getMessage());
            result = "Deposit failed";
        }
        return result;
    }

    @PostMapping("/withdraw/{accountNumber}/{amount}")
    public String withdraw(@PathVariable String accountNumber, @PathVariable int amount) {
        String result = "Withdraw success";
        try {
            accountService.withdraw(accountNumber, amount);

        } catch (AccountNotFoundException e) {
            logger.error("Error withdrawing amount, {}", e.getMessage());
            result = "Withdraw failed";
        }
        return result;
    }

}
