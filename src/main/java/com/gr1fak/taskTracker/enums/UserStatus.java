package com.gr1fak.taskTracker.enums;

public enum UserStatus {
    ACTIVE("Active"),
    BANNED("Banned");

    private final String status;

    UserStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
