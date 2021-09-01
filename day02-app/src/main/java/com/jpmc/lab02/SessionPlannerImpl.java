package com.jpmc.lab02;

import java.util.*;

public class SessionPlannerImpl implements SessionPlanner {
    private String topicsFor60Min;
    private String topicsFor50Min;
    private String topicsFor45Min;

    //private Properties anotherListOfTopics;
    private Map<String, String> anotherListOfTopics;
    private Map<Integer, List<String>> topics;

    public Map<Integer, List<String>> getTopics() {
        return topics;
    }

    public Map<String, String> getAnotherListOfTopics() {
        return anotherListOfTopics;
    }

    public void setAnotherListOfTopics(Map<String, String> anotherListOfTopics) {
        this.anotherListOfTopics = anotherListOfTopics;
    }

    public void init() {
        System.out.println(anotherListOfTopics);
        this.topics = new HashMap<>();
        constructTopicsMap(60, topicsFor60Min);
        constructTopicsMap(50, topicsFor50Min);
        constructTopicsMap(45, topicsFor45Min);
    }

    private void constructTopicsMap(int duration, String topicsInStr) {
        String[] topicsArr = topicsInStr.split(",");
        List<String> topicsLst = new ArrayList<>();
        for (String topic : topicsArr) {
            topicsLst.add(topic.trim());
        }
        this.topics.put(duration, topicsLst);
    }

    public String getTopicsFor60Min() {
        return topicsFor60Min;
    }

    public void setTopicsFor60Min(String topicsFor60Min) {
        this.topicsFor60Min = topicsFor60Min;
    }

    public String getTopicsFor50Min() {
        return topicsFor50Min;
    }

    public void setTopicsFor50Min(String topicsFor50Min) {
        this.topicsFor50Min = topicsFor50Min;
    }

    public String getTopicsFor45Min() {
        return topicsFor45Min;
    }

    public void setTopicsFor45Min(String topicsFor45Min) {
        this.topicsFor45Min = topicsFor45Min;
    }
}
