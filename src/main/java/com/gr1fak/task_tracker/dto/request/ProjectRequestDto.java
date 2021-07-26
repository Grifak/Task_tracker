package com.gr1fak.task_tracker.dto.request;

import com.gr1fak.task_tracker.dto.enums.ProjectStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Проект")
public class ProjectRequestDto {

    @Schema(description = "ID проекта")
    private UUID projectId;

    @Schema(description = "Название проекта")
    private String name;

    @Schema(description = "Описание проекта")
    private String description;

    @Schema(description = "Статус проекта")
    private ProjectStatus status;

    @Schema(description = "Заказдчик проекта")
    private String customer;

    public ProjectRequestDto() {
    }

    public ProjectRequestDto(UUID projectId, String name, String description,
                             ProjectStatus status, String customer) {
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.status = status;
        this.customer = customer;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

}
