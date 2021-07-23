package com.gr1fak.task_tracker.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Calendar;

@Schema(description = "Версия")
public class ReleaseRequestDto {
    @Schema(description = "ID версии")
    private Long releaseId;

    @Schema(description = "Название задачи")
    private String name;

    @Schema(description = "Начало проекта")
    private Calendar begin;

    @Schema(description = "Окночание задачи")
    private Calendar end;

    public ReleaseRequestDto() {
    }

    public ReleaseRequestDto(Long release_id, String name, Calendar begin, Calendar end) {
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
