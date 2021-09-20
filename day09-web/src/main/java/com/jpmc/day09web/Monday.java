package com.jpmc.day09web;

import org.springframework.web.bind.annotation.*;

@RestController
public class Monday {

    @GetMapping("/hello")
    public String greet() {
        return "Hello Spring boot";
    }

    //https://twitter.com/{handle} -> twitter.com/iamsrk, twitter.com/deepika
    //http://localhost:8080/hi/Ram -> Hi Ram!
    @GetMapping("/hi/{name}")
    public String sayHi(@PathVariable("name") String name) {
        return "Hi " + name;
    }

    @PostMapping("/greet")
    public String greetings() {
        return "Good morning";
    }

    //http://localhost:8080/bye?name=Sam
    @PostMapping("/bye")
    public String bye(@RequestParam("name") String name) {
        return "Bye Bye " + name;
    }

}
