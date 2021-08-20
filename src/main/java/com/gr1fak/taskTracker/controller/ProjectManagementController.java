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

@Tag(name = "Управление проектом")
@RequestMapping("api/management/project")
@RestController
public class ProjectManagementController {
    private ProjectService projectService;

    public ProjectManagementController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Operation()
    @PreAuthorize("hasAuthority('user:write')")
    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponseDto> finishProject(@PathVariable UUID id){
        ProjectResponseDto responseDto = projectService.finishProject(id);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Добавить проект")
    @PreAuthorize("hasAuthority('user:write')")
    @PostMapping(value = "/project")
    public ResponseEntity<ProjectResponseDto> createProject(@RequestBody ProjectRequestDto requestDto) {
        ProjectResponseDto responseDto = projectService.addProject(requestDto);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Обновление проекта")
    @PreAuthorize("hasAuthority('user:write')")
    @PutMapping(value = "/project/{id}")
    public ResponseEntity<ProjectResponseDto> partialUpdateProject(@PathVariable UUID id,
                                                                   @RequestBody ProjectRequestDto requestDto) {
        ProjectResponseDto responseDto = projectService.updateProject(id, requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Удаление проекта")
    @PreAuthorize("hasAuthority('admin:write')")
    @DeleteMapping(value = "/project/{id}")
    public ResponseEntity deleteProject(@PathVariable UUID id) {
        projectService.deleteProjectById(id);

        return ResponseEntity.ok().build();
    }
}
