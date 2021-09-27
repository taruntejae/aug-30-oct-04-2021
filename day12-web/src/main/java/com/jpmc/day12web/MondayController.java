package com.jpmc.day12web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
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
}
