package com.jpmc.day10web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/training")
public class TrainingController2 {

    //GET(retrieval), POST(creation), PUT(update all the fields except primary key), DELETE(removing), PATCH(partial updates)
    //URL should not contain verbs; should only contain NOUNS
    // @PostMapping("/training/create")

    @PostMapping()
    public String createTraining(@RequestBody Training training) {}

    @PatchMapping("/title/{title}/duration/{duration}")    //localhost:8080/training/title/Spring boot/duration/80
    public String updateTrainingDuration(@PathVariable String title, @PathVariable int duration) {}

    @DeleteMapping("/{title}")
    public String removeTraining(@PathVariable String title) {}

    @GetMapping("/{title}")
    public Training getTrainingInfo(@PathVariable String title) {}

    @PutMapping()    //localhost:8080/training/title/Spring boot/duration/80
    public String updateTrainingDuration(@RequestBody Training training) {}

}
