package com.gr1fak.task_tracker.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Исполнители задач")
public class UserTaskRequestDto {

    @Schema(description = "ID пользователя")
    private Long user_id;

    @Schema(description = "ID задачи")
    private Long task_id;

    public UserTaskRequestDto(Long user_id, Long task_id) {
        this.user_id = user_id;
        this.task_id = task_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }
}
