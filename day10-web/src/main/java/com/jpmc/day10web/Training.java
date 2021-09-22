package com.jpmc.day10web;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Training {
    @JsonProperty("title")
    private String name;

    @JsonProperty("hours")
    private long duration;
    private List<String> topics;

    @Override
    public String toString() {
        return "Training{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", topics=" + topics +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }
}
