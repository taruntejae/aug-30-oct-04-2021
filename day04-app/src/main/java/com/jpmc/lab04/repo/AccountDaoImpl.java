package com.jpmc.lab04.repo;

import com.jpmc.lab04.exception.AccountNotFoundException;
import com.jpmc.lab04.exception.AccountOperationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void deposit(String accountNumber, int amount) {
        checkIfAccountExists(accountNumber);
        String query = "update accounts set balance = balance + ? where account_number = ?";
        jdbcTemplate.update(query, amount, accountNumber);
    }

    @Override
    public void withdraw(String accountNumber, int amount) {
        checkIfAccountExists(accountNumber);
        String query = "update accounts set balance = balance - ? where account_number = ? and balance > ?";
        int rowsUpdated  = jdbcTemplate.update(query, amount, accountNumber, amount);
        if (rowsUpdated != 1) {
            throw new AccountOperationFailedException("Insufficient balance");
        }
    }

    private void checkIfAccountExists(String accountNumber) {
        try {
            jdbcTemplate.queryForObject("select balance from accounts where account_number=?", Integer.class, accountNumber);
        }
        catch(DataAccessException ex) {
            throw new AccountNotFoundException(String.format("Account %s is not found", accountNumber));
        }
    }

}
