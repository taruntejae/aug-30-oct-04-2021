package com.jpmc.day07ormapp.service;

import com.jpmc.day07ormapp.entity.Account;
import com.jpmc.day07ormapp.entity.Statement;
import com.jpmc.day07ormapp.exception.InsufficientBalanceException;
import com.jpmc.day07ormapp.repo.AccountRepository;
import com.jpmc.day07ormapp.repo.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private StatementRepository statementRepository;

    @Override
    public void deposit(String accountNumber, int amount) {
        Optional<Account> optAccount = accountRepository.findById(accountNumber);
        if(optAccount.isPresent()) {
            Account account = optAccount.get();
            account.setBalance(account.getBalance() + amount);

            Statement statement = getStatement(amount, account, "CREDIT");
            if(account.getStatements() == null ) {
                account.setStatements(new ArrayList<>());
            }
            account.getStatements().add(statement);
            accountRepository.save(account);
        }
    }

    @Override
    public void withdraw(String accountNumber, int amount) {
        Optional<Account> optAccount = accountRepository.findById(accountNumber);
        if(optAccount.isPresent()) {
            Account account = optAccount.get();
            if(account.getBalance() > amount) {
                account.setBalance(account.getBalance() - amount);

                Statement statement = getStatement(amount, account, "DEBIT");
                if(account.getStatements() == null ) {
                    account.setStatements(new ArrayList<>());
                }
                account.getStatements().add(statement);
                accountRepository.save(account);
            } else {
                throw new InsufficientBalanceException(amount + "");
            }

        }
    }

    private Statement getStatement(int amount, Account account, String type) {
        Statement statement = new Statement();
        statement.setAmount(amount);
        statement.setId((int)(Math.random() * 1000));
        statement.setType(type);
        statement.setAccount(account);
        return statement;
    }
}
