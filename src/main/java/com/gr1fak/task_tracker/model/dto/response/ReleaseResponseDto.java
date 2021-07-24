package com.gr1fak.task_tracker.model.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Calendar;

@Schema(description = "Версия")
public class ReleaseResponseDto {
    @Schema(description = "Название версии")
    private String name;

    @Schema(description = "Начало задачи")
    private Calendar begin;

    @Schema(description = "Конец задачи")
    private Calendar end;

    public ReleaseResponseDto(String name, Calendar begin, Calendar end) {
        this.name = name;
        this.begin = begin;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getBegin() {
        return begin;
    }

    public void setBegin(Calendar begin) {
        this.begin = begin;
    }

    public Calendar getEnd() {
        return end;
    }

    public void setEnd(Calendar end) {
        this.end = end;
    }
}
