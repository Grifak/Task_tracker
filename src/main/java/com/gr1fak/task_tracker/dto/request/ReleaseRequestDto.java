package com.gr1fak.task_tracker.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Версия")
public class ReleaseRequestDto {

    @Schema(description = "Название задачи")
    private String name;

    @Schema(description = "Начало проекта")
    private LocalDateTime begin;

    @Schema(description = "Окночание задачи")
    private LocalDateTime end;

    public ReleaseRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBegin() {
        return begin;
    }

    public void setBegin(LocalDateTime begin) {
        this.begin = begin;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}
