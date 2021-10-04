package com.jpmc.day15reactiveapp;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@RestController
public class SampleController {

    @GetMapping(value = "/numbers", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Integer> getNumbers() {
        return Flux
                .range(1, 10)
                .delayElements(Duration.ofSeconds(1L));
    }


//    @GetMapping(value = "/numbers")
//    public List<Integer> getNumbers() {
//        return Arrays.asList(1, 2, 3, 4, 5);
//    }
}
