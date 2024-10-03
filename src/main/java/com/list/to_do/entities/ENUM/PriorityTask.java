package com.list.to_do.entities.ENUM;

public enum PriorityTask {
    LOW("LOW"),
    MEDIUM("MEDIUM"),
    HIGH("HIGH"),
    URGENT("URGENT"),
    CRITICAL("CRITICAL");

    private String priority;

    PriorityTask(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }
}
