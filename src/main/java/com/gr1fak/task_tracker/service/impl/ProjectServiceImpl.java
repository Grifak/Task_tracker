package com.gr1fak.task_tracker.service.impl;

import com.gr1fak.task_tracker.dto.request.ProjectRequestDto;
import com.gr1fak.task_tracker.dto.response.ProjectResponseDto;
import com.gr1fak.task_tracker.model.ProjectEntity;
import com.gr1fak.task_tracker.mapper.ProjectMapper;
import com.gr1fak.task_tracker.repository.ProjectRepository;
import com.gr1fak.task_tracker.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;
    private ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
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
        projectRepository.save(projectEntity);
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
        projectRepository.save(entity);

        return projectMapper.projectToResponseDto(entity);
    }
}
