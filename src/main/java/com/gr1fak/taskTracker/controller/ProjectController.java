package com.gr1fak.taskTracker.controller;

import com.gr1fak.taskTracker.dto.request.ProjectRequestDto;
import com.gr1fak.taskTracker.dto.response.ProjectResponseDto;
import com.gr1fak.taskTracker.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RequestMapping("/api/project")
@Tag(name = "Проект")
@RestController
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Operation(summary = "Получить информацию о проекте")
    @PreAuthorize("hasAuthority('user:write')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProjectResponseDto> getProject(@PathVariable UUID id) {
        ProjectResponseDto responseDto = projectService.getById(id);
        return ResponseEntity.ok().body(responseDto);
    }
}
