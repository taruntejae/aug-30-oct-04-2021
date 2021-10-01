package com.jpmc.accountserviceapp;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String accountNumber) {
        super(accountNumber);
    }
}
