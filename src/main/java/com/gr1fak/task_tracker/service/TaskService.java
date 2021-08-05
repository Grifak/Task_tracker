package com.gr1fak.task_tracker.service;

import com.gr1fak.task_tracker.dto.request.TaskRequestDto;
import com.gr1fak.task_tracker.dto.response.TaskResponseDto;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    TaskResponseDto getById(UUID id);
    List<TaskResponseDto> getAll();
    TaskResponseDto addTask(TaskRequestDto requestDto);
    void deleteById(UUID id);
}
