package com.gr1fak.task_tracker.enums;

public enum ProjectStatus {
    NOT_STARTED("Not started"),
    STARTED("Started"),
    DONE("Done");

    private String title;

    ProjectStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
