package com.jpmc;

import org.springframework.stereotype.Component;

@Component
public class Engine {
    private int power;

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
