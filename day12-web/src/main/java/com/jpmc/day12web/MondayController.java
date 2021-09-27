package com.jpmc.day12web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class MondayController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/monday")
    public String doSomething(Locale locale) {
        return messageSource.getMessage("greet", null, locale);
        //return "Hello Monday!";
    }

    @GetMapping("/bye/{name}")
    public String sayBye(@PathVariable String name, Locale locale) {
        return messageSource.getMessage("bye", new String[]{name}, locale);
    }

    @PostMapping("/withdraw/{amount}")
    public String withdraw(@PathVariable int amount, Locale locale) {
        if (amount < 1000) {
            return messageSource.getMessage("error.invalid.amount", new String[]{amount+""}, locale);
        }
        return messageSource.getMessage("withdraw.success", null, locale);
    }

}
