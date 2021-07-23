package com.gr1fak.task_tracker.model.dto.enums;

public enum TaskStatus {

    BACKLOG("Backlog"),
    IN_PROGRESS("In progress"),
    DONE("Done");

    private String title;

    TaskStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
