package com.gr1fak.taskTracker.enums;

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
        for(final TaskStatus taskStatus: values()){
            if(taskStatus.title.equalsIgnoreCase(value)){
                return taskStatus;
            }
        }
        throw new RuntimeException(String.format("Статуса %s не сущесвтует", value));
    }
}
