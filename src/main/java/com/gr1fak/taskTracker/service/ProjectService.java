package com.gr1fak.taskTracker.service;

import com.gr1fak.taskTracker.dto.request.ProjectRequestDto;
import com.gr1fak.taskTracker.dto.response.ProjectResponseDto;

import java.util.UUID;


public interface ProjectService {
    ProjectResponseDto getById(UUID id);
    ProjectResponseDto addProject(ProjectRequestDto requestDto);
    void deleteProjectById(UUID id);
    ProjectResponseDto updateProject(UUID id, ProjectRequestDto requestDto);
    ProjectResponseDto finishProject(UUID id);
}
