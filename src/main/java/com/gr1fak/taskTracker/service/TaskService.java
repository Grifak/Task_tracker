package com.gr1fak.taskTracker.service;

import com.gr1fak.taskTracker.dto.request.TaskRequestDto;
import com.gr1fak.taskTracker.dto.response.TaskResponseDto;
import com.gr1fak.taskTracker.enums.TaskStatus;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    List<TaskResponseDto> getAll();
    TaskResponseDto addTask(TaskRequestDto requestDto);
    void deleteById(UUID id);
    TaskResponseDto setExecutor(UUID taskId, UUID userId);
    TaskResponseDto setRelease(UUID taskId, UUID releaseId);
    TaskResponseDto setStatus(UUID taskId, String status);
    Integer countIncompleteTaskInRelease(UUID releaseId);
    List<TaskResponseDto> findTasks(String name, TaskStatus status);
}
