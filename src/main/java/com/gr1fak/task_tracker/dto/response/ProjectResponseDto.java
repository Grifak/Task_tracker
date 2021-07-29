package com.gr1fak.task_tracker.dto.response;

import com.gr1fak.task_tracker.dto.enums.ProjectStatus;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Проект")
public class ProjectResponseDto {

    @Schema(description = "Название проекта")
    private String name;

    @Schema(description = "Описание проекта")
    private String description;

    @Schema(description = "Статус проекта")
    private ProjectStatus status;

    @Schema(description = "Заказдчик проекта")
    private String customer;

    public ProjectResponseDto(String name, String description,
                              ProjectStatus status, String customer) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.customer = customer;
    }

    public ProjectResponseDto() {

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

    public ProjectStatus isStatus() {
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
