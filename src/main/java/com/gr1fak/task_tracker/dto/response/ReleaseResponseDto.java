package com.gr1fak.task_tracker.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Версия")
public class ReleaseResponseDto {
    @Schema(description = "Название версии")
    private String name;

    @Schema(description = "Начало задачи")
    private LocalDateTime begin;

    @Schema(description = "Конец задачи")
    private LocalDateTime end;

    public ReleaseResponseDto(String name, LocalDateTime begin, LocalDateTime end) {
        this.name = name;
        this.begin = begin;
        this.end = end;
    }

    public ReleaseResponseDto() {

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
