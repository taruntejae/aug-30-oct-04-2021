package com.jpmc.day11calcui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Service
public class CalcService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${calc.service.base.url}")
    private String calcServiceBaseUrl;

    public String add(long number1, long number2) {
        String url = calcServiceBaseUrl + "/add/" + number1 + "/" + number2;
        ResponseEntity<Long> response = restTemplate.getForEntity(url, Long.class);
        String message = String.format("Sum of %d and %d is %d", number1, number2, response.getBody());
        return message;
    }
    public String subtract(long number1, long number2) {
        String url = calcServiceBaseUrl + "/subtract/" + number1 + "/" + number2;
        ResponseEntity<Long> response = restTemplate.getForEntity(url, Long.class);
        String message = String.format("Difference of %d and %d is %d", number1, number2, response.getBody());
        return message;
    }
}
