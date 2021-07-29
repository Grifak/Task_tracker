package com.gr1fak.task_tracker.service.impl;

import com.gr1fak.task_tracker.dto.request.TaskRequestDto;
import com.gr1fak.task_tracker.dto.response.TaskResponseDto;
import com.gr1fak.task_tracker.entities.TaskEntity;
import com.gr1fak.task_tracker.repository.TaskRepository;
import com.gr1fak.task_tracker.service.TaskService;
import org.webjars.NotFoundException;

import java.util.UUID;

public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskResponseDto getById(UUID id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Task with ID = " + id +" not found")
        );

        TaskResponseDto responseDto = new TaskResponseDto();
        //TODO mapStruct TaskEntityToTaskResponseDto
        return responseDto;
    }

    @Override
    public TaskResponseDto addTask(TaskRequestDto requestDto) {
        TaskEntity taskEntity = new TaskEntity();
        //TODO mapStruct TaskRequestDtoToTaskEntity
        TaskResponseDto responseDto = new TaskResponseDto();
        //TODO mapStruct TaskEntityToTaskResponseDto
        return responseDto;
    }
}
