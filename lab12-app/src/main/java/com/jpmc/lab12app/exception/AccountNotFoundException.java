package com.jpmc.lab12app.exception;


public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super("Account not found : " + message);
    }
}
