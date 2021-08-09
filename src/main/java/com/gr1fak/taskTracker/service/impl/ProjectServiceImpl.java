package com.gr1fak.taskTracker.service.impl;

import com.gr1fak.taskTracker.dto.request.ProjectRequestDto;
import com.gr1fak.taskTracker.dto.response.ProjectResponseDto;
import com.gr1fak.taskTracker.enums.ProjectStatus;
import com.gr1fak.taskTracker.enums.TaskStatus;
import com.gr1fak.taskTracker.model.ProjectEntity;
import com.gr1fak.taskTracker.mapper.ProjectMapper;
import com.gr1fak.taskTracker.model.TaskEntity;
import com.gr1fak.taskTracker.repository.ProjectRepository;
import com.gr1fak.taskTracker.repository.TaskRepository;
import com.gr1fak.taskTracker.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;
    private ProjectMapper projectMapper;
    private TaskRepository taskRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper,
                              TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
        this.taskRepository = taskRepository;
    }

    @Transactional
    @Override
    public ProjectResponseDto getById(UUID id) {
        ProjectEntity projectEntity = projectRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Project with ID = %s not found", id))
        );

        return projectMapper.projectToResponseDto(projectEntity);
    }

    @Transactional
    @Override
    public ProjectResponseDto addProject(ProjectRequestDto requestDto) {
        ProjectEntity projectEntity = projectMapper.requestDtoToProject(requestDto);

        return projectMapper.projectToResponseDto(projectEntity);
    }

    @Transactional
    @Override
    public void deleteProjectById(UUID id) {
        projectRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Project with ID = %s not found", id))
        );

        projectRepository.deleteById(id);
    }

    @Transactional
    @Override
    public ProjectResponseDto updateProject(UUID id, ProjectRequestDto requestDto) {
        ProjectEntity entity = projectRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Project with ID = %s not found", id))
        );
        entity.setName(requestDto.getName());
        entity.setDescription(requestDto.getDescription());
        entity.setCustomer(requestDto.getCustomer());
        entity.setStatus(requestDto.getStatus());

        return projectMapper.projectToResponseDto(entity);
    }

    @Transactional
    @Override
    public ProjectResponseDto finishProject(UUID id) {
        ProjectEntity projectEntity = projectRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Project with ID = %s not found", id))
        );
        projectEntity.setStatus(ProjectStatus.DONE);
        List<TaskEntity> tasks = taskRepository.findAllByProjectId(id);

        tasks.stream().
                filter(t->!t.getStatus().equals(TaskStatus.DONE)).
                collect(Collectors.toList()).
                forEach(t->t.setStatus(TaskStatus.EXPIRED));

        return projectMapper.projectToResponseDto(projectEntity);
    }
}
