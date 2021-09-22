package com.jpmc.lab13app.exception;

public class PersonNotFoundException extends Exception {
    public PersonNotFoundException(int id) {
        super("" + id);
    }
}
