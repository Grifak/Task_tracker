package com.gr1fak.task_tracker.service.impl;

import com.gr1fak.task_tracker.dto.request.TaskRequestDto;
import com.gr1fak.task_tracker.dto.response.TaskResponseDto;
import com.gr1fak.task_tracker.mapper.TaskContext;
import com.gr1fak.task_tracker.model.TaskEntity;
import com.gr1fak.task_tracker.mapper.TaskMapper;
import com.gr1fak.task_tracker.repository.ProjectRepository;
import com.gr1fak.task_tracker.repository.ReleaseRepository;
import com.gr1fak.task_tracker.repository.TaskRepository;
import com.gr1fak.task_tracker.repository.UserRepository;
import com.gr1fak.task_tracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskResponseDto getById(UUID id) {
        TaskEntity entity = taskRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Task with ID = %s not found", id))
        );

        return TaskMapper.INSTANCE.taskToResponseDto(entity);
    }

    @Transactional
    @Override
    public List<TaskResponseDto> getAll() {
        List<TaskEntity> taskEntity = taskRepository.findAll();
        List<TaskResponseDto> responseDtoList = new ArrayList<>();

        for(TaskEntity entity: taskEntity){
            responseDtoList.add(TaskMapper.INSTANCE.taskToResponseDto(entity));
        }

        return responseDtoList;
    }

    @Transactional
    @Override
    public TaskResponseDto addTask(TaskRequestDto requestDto) {
        TaskEntity taskEntity = TaskMapper.INSTANCE.taskRequestDtoToTask(requestDto);
        taskRepository.save(taskEntity);

        return TaskMapper.INSTANCE.taskToResponseDto(taskEntity);
    }

    @Transactional
    @Override
    public void deleteById(UUID id) {
        taskRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Task with ID = %s not found", id))
        );

        taskRepository.deleteById(id);
    }
}
