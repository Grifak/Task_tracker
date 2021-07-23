package com.gr1fak.task_tracker.model.dto.request;

import com.gr1fak.task_tracker.model.dto.enums.ProjectStatus;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Проект")
public class ProjectRequestDto {

    @Schema(description = "ID проекта")
    private Long projectId;

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

    public ProjectRequestDto(Long projectId, String name, String description,
                             ProjectStatus status, String customer) {
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.status = status;
        this.customer = customer;
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
