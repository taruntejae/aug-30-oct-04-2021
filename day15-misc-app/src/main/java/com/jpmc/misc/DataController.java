package com.jpmc.misc;

import com.jpmc.misc.accounts.Account;
import com.jpmc.misc.accounts.AccountRepository;
import com.jpmc.misc.accounts.Statement;
import com.jpmc.misc.persons.Person;
import com.jpmc.misc.persons.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class DataController {
    @Autowired
    private AccountRepository accountRepository;

    @Value("${welcome}")
    private String welcome;

    @Autowired
    private PersonRepository personRepository;


    @GetMapping("/welcome")
    public String getWelcome() {
        return welcome;
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @PostMapping("/accounts")
    public String create() {
        Account account = new Account();
        account.setAccountNumber("acc10111");
        account.setBalance(1212);
        Statement stmt = new Statement();
        stmt.setType("Credit");
        stmt.setAmount(1212);
        stmt.setAccount(account);
        account.setStatements(Arrays.asList(stmt));
        accountRepository.save(account);
        return "done";
    }
}
