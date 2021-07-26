package com.gr1fak.task_tracker.dto.request;

import com.gr1fak.task_tracker.dto.enums.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Задача")
public class TaskRequestDto {
    @Schema(description = "ID Задача")
    private UUID taskId;

    @Schema(description = "ID автора")
    private UUID authorId;

    @Schema(description = "ID проекта")
    private UUID projectId;

    @Schema(description = "ID версии")
    private UUID releaseId;

    @Schema(description = "Название здачи")
    private String name;

    @Schema(description = "Статус задачи")
    private TaskStatus status;

    public TaskRequestDto() {
    }

    public TaskRequestDto(UUID taskId, UUID authorId, UUID projectId,
                          UUID releaseId, String name, TaskStatus status) {
        this.taskId = taskId;
        this.authorId = authorId;
        this.projectId = projectId;
        this.releaseId = releaseId;
        this.name = name;
        this.status = status;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public UUID getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(UUID releaseId) {
        this.releaseId = releaseId;
    }

    public UUID getTaskId() {
        return taskId;
    }

    public void setTaskId(UUID taskId) {
        this.taskId = taskId;
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
