package com.gr1fak.task_tracker.service.impl;

import com.gr1fak.task_tracker.dto.request.ProjectRequestDto;
import com.gr1fak.task_tracker.dto.response.ProjectResponseDto;
import com.gr1fak.task_tracker.entities.ProjectEntity;
import com.gr1fak.task_tracker.repository.ProjectRepository;
import com.gr1fak.task_tracker.service.ProjectService;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectResponseDto getById(UUID id) {
        ProjectEntity projectEntity = projectRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Project with ID = " + id +" not found")
        );

        ProjectResponseDto responseDto = new ProjectResponseDto();
        //TODO mapStruct ProjectEntityToProjectResponseDto
        return responseDto;
    }

    @Override
    public ProjectResponseDto addProject(ProjectRequestDto requestDto) {
        ProjectEntity projectEntity = new ProjectEntity();
        //TODO mapStruct ProjectRequestDtoToProjectEntity
        ProjectResponseDto responseDto = new ProjectResponseDto();
        //TODO mapStruct ProjectEntityToProjectResponseDto
        return responseDto;
    }
}
