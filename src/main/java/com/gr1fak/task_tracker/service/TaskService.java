package com.gr1fak.task_tracker.service;

import com.gr1fak.task_tracker.dto.request.TaskRequestDto;
import com.gr1fak.task_tracker.dto.response.TaskResponseDto;

import java.util.UUID;

public interface TaskService {
    TaskResponseDto getById(UUID id);
    TaskResponseDto addTask(TaskRequestDto requestDto);
}
