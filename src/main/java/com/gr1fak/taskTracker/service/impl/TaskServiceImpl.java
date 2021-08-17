package com.gr1fak.taskTracker.service.impl;

import com.gr1fak.taskTracker.dto.request.TaskRequestDto;
import com.gr1fak.taskTracker.dto.response.TaskResponseDto;
import com.gr1fak.taskTracker.enums.TaskStatus;
import com.gr1fak.taskTracker.model.ReleaseEntity;
import com.gr1fak.taskTracker.model.TaskEntity;
import com.gr1fak.taskTracker.mapper.TaskMapper;
import com.gr1fak.taskTracker.model.UserEntity;
import com.gr1fak.taskTracker.repository.ReleaseRepository;
import com.gr1fak.taskTracker.repository.TaskRepository;
import com.gr1fak.taskTracker.repository.UserRepository;
import com.gr1fak.taskTracker.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;
    private TaskMapper taskMapper;
    private UserRepository userRepository;
    private ReleaseRepository releaseRepository;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper,
                           UserRepository userRepository, ReleaseRepository releaseRepository) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.userRepository = userRepository;
        this.releaseRepository = releaseRepository;
    }

    @Transactional
    @Override
    public List<TaskResponseDto> getAll() {
        List<TaskEntity> taskEntity = taskRepository.findAll();
        List<TaskResponseDto> responseDtoList = new ArrayList<>();

        taskEntity.stream().
                forEach(t->responseDtoList.add(taskMapper.taskToResponseDto(t)));

        return responseDtoList;
    }

    @Transactional
    @Override
    public TaskResponseDto addTask(TaskRequestDto requestDto) {
        TaskEntity taskEntity = taskMapper.taskRequestDtoToTask(requestDto);
        taskRepository.save(taskEntity);

        return taskMapper.taskToResponseDto(taskEntity);
    }

    @Transactional
    @Override
    public void deleteById(UUID id) {
        taskRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Task with ID = %s not found", id))
        );

        taskRepository.deleteById(id);
    }

    @Transactional
    @Override
    public TaskResponseDto setExecutor(UUID taskId, UUID userId) {
        TaskEntity taskEntity = taskRepository.findById(taskId).orElseThrow(
                () -> new NotFoundException(String.format("Task with ID = %s not found", taskId))
        );

        UserEntity userEntity = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(String.format("User with ID = %s not found", userId))
        );

        taskEntity.addExecutor(userEntity);

        return taskMapper.taskToResponseDto(taskEntity);
    }

    @Transactional
    @Override
    public TaskResponseDto setRelease(UUID taskId, UUID releaseId) {
        TaskEntity taskEntity = taskRepository.findById(taskId).orElseThrow(
                () -> new NotFoundException(String.format("Task with ID = %s not found", taskId))
        );

        ReleaseEntity releaseEntity = releaseRepository.findById(releaseId).orElseThrow(
                () -> new NotFoundException(String.format("Release with ID = %s not found", releaseId))
        );

        taskEntity.setRelease(releaseEntity);

        return taskMapper.taskToResponseDto(taskEntity);
    }

    @Transactional
    @Override
    public TaskResponseDto setStatus(UUID taskId, String status) {
        TaskEntity taskEntity = taskRepository.findById(taskId).orElseThrow(
                () -> new NotFoundException(String.format("Task with ID = %s not found", taskId))
        );

        taskEntity.setStatus(TaskStatus.fromValue(status));

        return taskMapper.taskToResponseDto(taskEntity);
    }

    @Override
    public Integer countIncompleteTaskInRelease(UUID releaseId) {
        List<TaskEntity> tasks = taskRepository.getIncompleteTaskInRelease(releaseId);

        return tasks.size();
    }
}
