package com.jpmc;

public class Training {
    private String message;
    public Training(String message) {
        this.message = "V2: " + message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
