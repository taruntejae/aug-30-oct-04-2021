package com.jpmc.accountserviceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public void deposit(String accountNumber, int amount) throws AccountNotFoundException {
        Optional<Account> optionalAccount = accountRepository.findById(accountNumber);
        if(optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setBalance(account.getBalance() + amount);
            accountRepository.save(account);
        } else {
            throw new AccountNotFoundException(accountNumber);
        }
    }

    public void withdraw(String accountNumber, int amount) throws AccountNotFoundException {
        Optional<Account> optionalAccount = accountRepository.findById(accountNumber);
        if(optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setBalance(account.getBalance() - amount); //Ignoring the mandatory check
            accountRepository.save(account);
        } else {
            throw new AccountNotFoundException(accountNumber);
        }
    }
}
