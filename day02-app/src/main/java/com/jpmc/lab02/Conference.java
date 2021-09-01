package com.jpmc.lab02;

public class Conference {
    private SessionPlanner sessionPlanner;

    public SessionPlanner getSessionPlanner() {
        return sessionPlanner;
    }

    public void setSessionPlanner(SessionPlanner sessionPlanner) {
        this.sessionPlanner = sessionPlanner;
    }

    public int getTotalNumberOf45MinTopics() {
        return sessionPlanner.getTopics().get(45).size();
    }

    public int getTotalNumberOf50MinTopics() {
        return sessionPlanner.getTopics().get(50).size();
    }

    public int getTotalNumberOf60MinTopics() {
        return sessionPlanner.getTopics().get(60).size();
    }
}
