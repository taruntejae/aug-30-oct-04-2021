package com.jpmc.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class StockQuoteReceiver {
    @JmsListener(destination = "StockQueue")
    public void consumeStockSymbol(String symbol) {
        //IDEALLY you will connect to say Google or Yahoo Finance
        //Get the price
        //Email or Message or Store

        //For training purpose we'll just generate a random number
        //And print on the console
        double price = Math.random() * 1000;
        System.out.println("CMP of " + symbol + " is " + price);
    }
    @JmsListener(destination = "CalculatorQueue")
    public void add(String numbers) {
        String[] values = numbers.split(";");
        int a = Integer.parseInt(values[0]);
        int b = Integer.parseInt(values[1]);
        System.out.println(String.format("Sum of %d and %d is %d", a, b, (a+b)));
    }
}
