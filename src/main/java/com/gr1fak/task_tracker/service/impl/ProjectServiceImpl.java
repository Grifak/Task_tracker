package com.gr1fak.task_tracker.service.impl;

import com.gr1fak.task_tracker.dto.request.ProjectRequestDto;
import com.gr1fak.task_tracker.dto.response.ProjectResponseDto;
import com.gr1fak.task_tracker.entities.ProjectEntity;
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

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Transactional
    @Override
    public ProjectResponseDto getById(UUID id) {
        ProjectEntity projectEntity = projectRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Project with ID = %d not found", id))
        );

        return ProjectMapper.INSTANCE.projectToResponseDto(projectEntity);
    }

    @Transactional
    @Override
    public ProjectResponseDto addProject(ProjectRequestDto requestDto) {
        ProjectEntity projectEntity = ProjectMapper.INSTANCE.requestDtoToProject(requestDto);
        projectRepository.save(projectEntity);
        return ProjectMapper.INSTANCE.projectToResponseDto(projectEntity);
    }

    @Transactional
    @Override
    public void deleteProjectById(UUID id) {
        projectRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Project with ID = %d not found", id))
        );

        projectRepository.deleteById(id);
    }
}
