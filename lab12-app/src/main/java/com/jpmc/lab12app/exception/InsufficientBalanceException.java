package com.jpmc.lab12app.exception;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(int amount) {
        super("Insufficient balance: " + amount);
    }
}
