package com.jpmc;

public class Person {
    private String name;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("***Person init called");
    }
    public void destroy() {
        System.out.println("***Person destroy called");
    }
}
