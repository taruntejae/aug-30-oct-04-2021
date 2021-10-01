package com.jpmc.bankuiapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

@Service
public class RemoteService {
    @Value("${account.service.base.url}")
    private String accountServiceBaseUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Async("threadPoolExecutor")
    public void deposit(String accountNumber, int amount) {
        System.out.println("Remote Service thread -- " + Thread.currentThread().getName());
        String url = String.format("%s/deposit/%s/%d", accountServiceBaseUrl, accountNumber, amount);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, null, String.class);
        String message = responseEntity.getBody();
        System.out.println("*********** " + message);
    }
}
