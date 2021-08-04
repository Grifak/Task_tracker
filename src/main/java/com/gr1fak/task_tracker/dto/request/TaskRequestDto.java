package com.gr1fak.task_tracker.dto.request;

import com.gr1fak.task_tracker.enums.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Задача")
public class TaskRequestDto {
    @Schema(description = "Название здачи")
    private String name;

    @Schema(description = "Статус задачи")
    private TaskStatus status;

    @Schema(description = "ID автора")
    private UUID author;

    @Schema(description = "ID проекта")
    private UUID project;

    @Schema(description = "ID версии")
    private UUID release;

    public TaskRequestDto() {
    }

    public TaskRequestDto(UUID author, UUID project,
                          UUID release, String name, TaskStatus status) {
        this.author = author;
        this.project = project;
        this.release = release;
        this.name = name;
        this.status = status;
    }

    public UUID getAuthor() {
        return author;
    }

    public void setAuthor(UUID author) {
        this.author = author;
    }

    public UUID getProject() {
        return project;
    }

    public void setProject(UUID project) {
        this.project = project;
    }

    public UUID getRelease() {
        return release;
    }

    public void setRelease(UUID release) {
        this.release = release;
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
