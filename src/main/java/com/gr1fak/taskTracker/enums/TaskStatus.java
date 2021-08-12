package com.gr1fak.taskTracker.enums;

import java.util.Arrays;

public enum TaskStatus {
    BACKLOG("Backlog"),
    IN_PROGRESS("In progress"),
    DONE("Done"),
    EXPIRED("Expired");

    private String title;

    TaskStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static TaskStatus fromValue(String value){
        return Arrays.stream(TaskStatus.values()).
                filter(v->v.title.equalsIgnoreCase(value)).
                findFirst().
                orElseThrow(
                        ()->new RuntimeException(String.format("Статуса %s не существует", value))
                );
    }
}
