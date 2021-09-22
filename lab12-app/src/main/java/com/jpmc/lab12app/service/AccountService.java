package com.jpmc.lab12app.service;

import com.jpmc.lab12app.entity.Account;
import com.jpmc.lab12app.exception.AccountNotFoundException;
import com.jpmc.lab12app.exception.InsufficientBalanceException;
import com.jpmc.lab12app.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public void deposit(String accountNumber, int amount) throws AccountNotFoundException {
        Optional<Account> optAccount = accountRepository.findById(accountNumber);
        if(optAccount.isPresent()) {
            Account account = optAccount.get();
            account.setBalance(account.getBalance() + amount);
            accountRepository.save(account);
        } else {
            throw new AccountNotFoundException(accountNumber);
        }
    }

    public void withdraw(String accountNumber, int amount) throws AccountNotFoundException, InsufficientBalanceException {
        Optional<Account> optAccount = accountRepository.findById(accountNumber);
        if(optAccount.isPresent()) {
            Account account = optAccount.get();
            if(account.getBalance() > amount) {
                account.setBalance(account.getBalance() - amount);
                accountRepository.save(account);
            } else {
                throw new InsufficientBalanceException(amount);
            }
        } else {
            throw new AccountNotFoundException(accountNumber);
        }
    }
}
