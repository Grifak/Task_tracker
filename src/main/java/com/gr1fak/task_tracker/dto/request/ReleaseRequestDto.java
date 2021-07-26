package com.gr1fak.task_tracker.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Версия")
public class ReleaseRequestDto {
    @Schema(description = "ID версии")
    private Long releaseId;

    @Schema(description = "Название задачи")
    private String name;

    @Schema(description = "Начало проекта")
    private LocalDateTime begin;

    @Schema(description = "Окночание задачи")
    private LocalDateTime end;

    public ReleaseRequestDto() {
    }

    public ReleaseRequestDto(Long release_id, String name, LocalDateTime begin, LocalDateTime end) {
        this.releaseId = release_id;
        this.name = name;
        this.begin = begin;
        this.end = end;
    }

    public Long getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(Long releaseId) {
        this.releaseId = releaseId;
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
