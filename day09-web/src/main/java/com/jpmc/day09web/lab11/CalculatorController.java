package com.jpmc.day09web.lab11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calc")
public class CalculatorController {
    @Autowired
    private Calculator calculator;// = new Calculator();

    @GetMapping("/add/{a}/{b}")
    public int add(@PathVariable("a") int a, @PathVariable("b") int b) {
        return calculator.add(a, b);
    }

    @GetMapping("/square/{a}")
    public int square(@PathVariable("a") int a) {
        return calculator.square(a);
    }

    @PutMapping("/subtract/{a}/{b}")
    public int subtract(@PathVariable("a") int a, @PathVariable("b") int b) {
        return calculator.subtract(a, b);
    }

    @PostMapping("/product")
    public int multiply(@RequestParam("a") int a, @RequestParam("b") int b) {
        return calculator.multiply(a, b);
    }
}
