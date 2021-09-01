package com.jpmc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//<bean id="car" class="com.jpmc.Car"/>
@Component
@Scope("prototype")
public class Car {
    @Value("BMW")
    private String model;

    @Value("2020")
    private int yearOfMake;

    //<property name="engine" ref="engine"/>
    @Autowired
    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfMake() {
        return yearOfMake;
    }

    public void setYearOfMake(int yearOfMake) {
        this.yearOfMake = yearOfMake;
    }
}
