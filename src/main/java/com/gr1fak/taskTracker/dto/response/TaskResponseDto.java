package com.gr1fak.taskTracker.dto.response;


import com.gr1fak.taskTracker.enums.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Задача")
public class TaskResponseDto {
    @Schema(description = "Название здачи")
    private String name;

    @Schema(description = "Статус задачи")
    private TaskStatus status;


    public TaskResponseDto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status.getTitle();
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
