package com.jpmc.day12web;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
@Api(value="Calculator", tags = {"REST API for Calculator"})
public class CalcController {

    @ApiOperation(value = "Addition", notes = "Add two numbers")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sum"),
            @ApiResponse(code = 500, message = "Oops!!!")
    })
    @GetMapping("/add/{a}/{b}")
    public long add(@PathVariable @ApiParam(example = "12") long a,
                    @ApiParam(example = "34") @PathVariable long b) {
        return a + b;
    }

    @ApiOperation(value = "Subtraction", notes = "Subtract two numbers")
    @GetMapping("/subtract/{a}/{b}")
    public long subtract(@PathVariable long a, @PathVariable long b) {
        return a - b;
    }
}
