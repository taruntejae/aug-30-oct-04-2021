package com.jpmc.day11calcapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalcController {

    @GetMapping("/add/{a}/{b}")
    public long add(@PathVariable long a, @PathVariable long b) {
        return a + b;
    }
    @GetMapping("/subtract/{a}/{b}")
    public long subtract(@PathVariable long a, @PathVariable long b) {
        return a - b;
    }
}
