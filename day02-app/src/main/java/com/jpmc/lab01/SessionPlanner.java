package com.jpmc.lab01;

import java.util.List;
import java.util.Map;

public interface SessionPlanner {
    public Map<Integer, List<String>> getTopics();
    public void setTopics(Map<Integer, List<String>> topics);
}
