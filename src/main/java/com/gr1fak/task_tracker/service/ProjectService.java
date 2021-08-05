package com.gr1fak.task_tracker.service;

import com.gr1fak.task_tracker.dto.request.ProjectRequestDto;
import com.gr1fak.task_tracker.dto.response.ProjectResponseDto;

import java.util.UUID;


public interface ProjectService {
    ProjectResponseDto getById(UUID id);
    ProjectResponseDto addProject(ProjectRequestDto requestDto);
    void deleteProjectById(UUID id);
    ProjectResponseDto updateProject(UUID id, ProjectRequestDto requestDto);
}
