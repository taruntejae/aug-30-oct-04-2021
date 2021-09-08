package com.jpmc.lab06.repo.exception;

public class TopicAlreadyExistsException extends RuntimeException {
    public TopicAlreadyExistsException(String message) {
        super(message);
    }
}
