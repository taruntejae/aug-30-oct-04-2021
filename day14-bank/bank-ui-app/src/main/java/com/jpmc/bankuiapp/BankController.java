package com.jpmc.bankuiapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/bank")
public class BankController {

    @Value("${account.service.base.url}")
    private String accountServiceBaseUrl;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping
    public String getIndexPage() {
        return "index";
    }

    @Autowired
    private RemoteService remoteService;

    @PostMapping("/depositlater")
    @ResponseBody
    public String depositLater(@RequestParam("accountnumber") String accountNumber,
                          @RequestParam int amount) {
        System.out.println("Controller thread -- " + Thread.currentThread().getName());
        remoteService.deposit(accountNumber, amount);
        return "Deposit scheduled";
    }


    @PostMapping("/deposit")
    public String deposit(@RequestParam("accountnumber") String accountNumber,
                          @RequestParam int amount, HttpSession session) {
        String url = String.format("%s/deposit/%s/%d", accountServiceBaseUrl, accountNumber, amount);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, null, String.class);
        String message = responseEntity.getBody();
        session.setAttribute("message", message);
        return "index";
    }
    @PostMapping("/withdraw")
    public String withdraw(@RequestParam("accountnumber") String accountNumber,
                          @RequestParam int amount, HttpSession session) {
        String url = String.format("%s/withdraw/%s/%d", accountServiceBaseUrl, accountNumber, amount);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, null, String.class);
        String message = responseEntity.getBody();
        session.setAttribute("message", message);
        return "index";
    }
}
