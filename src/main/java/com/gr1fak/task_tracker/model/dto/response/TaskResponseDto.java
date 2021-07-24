package com.gr1fak.task_tracker.model.dto.response;

import com.gr1fak.task_tracker.model.dto.enums.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Задача")
public class TaskResponseDto {
    @Schema(description = "Название здачи")
    private String name;

    @Schema(description = "Статус задачи")
    private TaskStatus status;


    public TaskResponseDto( String name, TaskStatus status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
