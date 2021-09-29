package com.jpmc.day13txnapp;

import com.jpmc.day13txnapp.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day13TxnAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Day13TxnAppApplication.class, args);
    }

    @Autowired
    private ShoppingService shoppingService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(shoppingService.getClass().getName());
        System.out.println(shoppingService.getClass().getSuperclass().getName());

        //shoppingService.placeOrder("printer", 10, "Adyar, Chennai asifjgasdifgsdalfg asdlijfgaklsjdgfkalsjgf klsajdgf klsajgf lksajgflksajgfkalsjfgsdklafjgaskldjfg askljfg ksaljfgsla");
        //System.out.println("Order for printer placed successfully");
    }
}
