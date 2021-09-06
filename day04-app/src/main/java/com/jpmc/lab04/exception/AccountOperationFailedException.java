package com.jpmc.lab04.exception;

public class AccountOperationFailedException extends RuntimeException {
    public AccountOperationFailedException(String message) {
        super(message);
    }
}
