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
    private UUID authorId;

    @Schema(description = "ID проекта")
    private UUID projectId;

    @Schema(description = "ID версии")
    private UUID releaseId;

    public TaskRequestDto() {
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
