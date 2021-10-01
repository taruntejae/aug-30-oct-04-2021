package com.jpmc.bankuiapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/bank")
public class BankController {

    @GetMapping
    public String getIndexPage() {
        return "index";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam("accountnumber") String accountNumber,
                          @RequestParam int amount, HttpSession session) {
        //Process here
        String message = "Deposit successful";
        session.setAttribute("message", message);
        return "index";
    }
    @PostMapping("/withdraw")
    public String withdraw(@RequestParam("accountnumber") String accountNumber,
                          @RequestParam int amount, HttpSession session) {
        //Process here
        String message = "Withdraw successful";
        session.setAttribute("message", message);
        return "index";
    }
}
