package com.gr1fak.task_tracker.model.dto.request;

import com.gr1fak.task_tracker.model.dto.enums.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Задача")
public class TaskRequestDto {
    @Schema(description = "ID Задача")
    private Long task_id;

    @Schema(description = "ID автора")
    private Long author_id;

    @Schema(description = "ID проекта")
    private Long project_id;

    @Schema(description = "ID версии")
    private Long release_id;

    @Schema(description = "Название здачи")
    private String name;

    @Schema(description = "Статус задачи")
    private TaskStatus status;

    public TaskRequestDto() {
    }

    public TaskRequestDto(Long task_id, Long author_id, Long project_id,
                          Long release_id, String name, TaskStatus status) {
        this.task_id = task_id;
        this.author_id = author_id;
        this.project_id = project_id;
        this.release_id = release_id;
        this.name = name;
        this.status = status;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public Long getProject_id() {
        return project_id;
    }

    public void setProject_id(Long project_id) {
        this.project_id = project_id;
    }

    public Long getRelease_id() {
        return release_id;
    }

    public void setRelease_id(Long release_id) {
        this.release_id = release_id;
    }

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
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
