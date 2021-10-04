package com.jpmc.day15cachingapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/hi/{name}")
    public String sayHi(@PathVariable String name) {
        String message = sampleService.computeMessage(name);
        return message;
    }

    @GetMapping("/bye/{name}")
    public String sayBye(@PathVariable String name) {
        String message = sampleService.computeByeMessage(name);
        return message;
    }
}
