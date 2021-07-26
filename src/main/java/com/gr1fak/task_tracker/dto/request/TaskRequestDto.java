package com.gr1fak.task_tracker.dto.request;

import com.gr1fak.task_tracker.dto.enums.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Задача")
public class TaskRequestDto {
    @Schema(description = "ID Задача")
    private Long taskId;

    @Schema(description = "ID автора")
    private Long authorId;

    @Schema(description = "ID проекта")
    private Long projectId;

    @Schema(description = "ID версии")
    private Long releaseId;

    @Schema(description = "Название здачи")
    private String name;

    @Schema(description = "Статус задачи")
    private TaskStatus status;

    public TaskRequestDto() {
    }

    public TaskRequestDto(Long taskId, Long authorId, Long projectId,
                          Long releaseId, String name, TaskStatus status) {
        this.taskId = taskId;
        this.authorId = authorId;
        this.projectId = projectId;
        this.releaseId = releaseId;
        this.name = name;
        this.status = status;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(Long releaseId) {
        this.releaseId = releaseId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
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
