package com.jpmc.day11calcui;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UIController {
    @PostMapping("/add")
    public String add(@RequestParam("number1") long number1, @RequestParam("number2") long number2) {
        return "We will add " + number1 + " and " + number2 + " and get back to you";
    }
    @PostMapping("/subtract")
    public String subtract(@RequestParam("number1") long number1, @RequestParam("number2") long number2) {
        return "We will subtract " + number1 + " and " + number2 + " and get back to you";
    }
}
