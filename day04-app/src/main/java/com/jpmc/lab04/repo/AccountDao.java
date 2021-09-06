package com.jpmc.lab04.repo;

public interface AccountDao {
    void deposit(String accountNumber,int amount);
    void withdraw(String accountNumber,int amount);
}
