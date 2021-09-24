package com.jpmc.day11calcui.controller;

import com.jpmc.day11calcui.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UIController {

    @Autowired
    private CalcService calcService;

    @PostMapping("/add")
    public String add(@RequestParam("number1") long number1, @RequestParam("number2") long number2) {
        return calcService.add(number1, number2);
    }
    @PostMapping("/subtract")
    public String subtract(@RequestParam("number1") long number1, @RequestParam("number2") long number2) {
        return calcService.subtract(number1, number2);
    }
}
