package com.gr1fak.task_tracker.model.dto.enums;

public enum ProjectStatus {

    NOT_STARTED("Not started"),
    STARTED("Started");

    private String title;

    ProjectStatus(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
