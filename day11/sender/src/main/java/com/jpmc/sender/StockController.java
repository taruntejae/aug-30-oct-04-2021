package com.jpmc.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/stock/{symbol}")
    public String getCMP(@PathVariable String symbol) {
        jmsTemplate.convertAndSend("StockQueue", symbol);
        return "You'll receive the details soon";
    }
    @GetMapping("/calc/add/{a}/{b}")
    public String add(@PathVariable int a, @PathVariable int b) {
        jmsTemplate.convertAndSend("CalculatorQueue", a + ";" + b);
        return "You'll receive the sum soon";
    }

}
