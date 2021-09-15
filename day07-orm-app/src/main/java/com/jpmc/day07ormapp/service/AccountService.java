package com.jpmc.day07ormapp.service;

public interface AccountService {
    void deposit(String accountNumber, int amount);
    void withdraw(String accountNumber, int amount);
}
