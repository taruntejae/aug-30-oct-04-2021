package com.jpmc.lab04.service;

import com.jpmc.lab04.repo.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    public void deposit(String accountNumber, int amount) {
        accountDao.deposit(accountNumber, amount);
    }
    public void withdraw(String accountNumber, int amount) {
        accountDao.withdraw(accountNumber, amount);
    }
}
