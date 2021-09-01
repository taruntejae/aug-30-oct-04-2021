package com.jpmc.lab01;

import java.util.List;
import java.util.Map;

public class SessionPlannerImpl2 implements SessionPlanner {
    private Map<Integer, List<String>> topics;

    @Override
    public Map<Integer, List<String>> getTopics() {
        return topics;
    }

    @Override
    public void setTopics(Map<Integer, List<String>> topics) {
        this.topics = topics;
    }
}
