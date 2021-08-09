package com.gr1fak.taskTracker.controller;

import com.gr1fak.taskTracker.dto.request.ProjectRequestDto;
import com.gr1fak.taskTracker.dto.response.ProjectResponseDto;
import com.gr1fak.taskTracker.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProjectResponseDto> getProject(@PathVariable UUID id) {
        ProjectResponseDto responseDto = projectService.getById(id);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Добавить проект")
    @PostMapping(value = "/project")
    public ResponseEntity<ProjectResponseDto> createProject(@RequestBody ProjectRequestDto requestDto) {
        ProjectResponseDto responseDto = projectService.addProject(requestDto);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Обновление проекта")
    @PutMapping(value = "/project/{id}")
    public ResponseEntity<ProjectResponseDto> partialUpdateProject(@PathVariable UUID id,
                                                                @RequestBody ProjectRequestDto requestDto) {
        ProjectResponseDto responseDto = projectService.updateProject(id, requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Удаление проекта")
    @DeleteMapping(value = "/project/{id}")
    public ResponseEntity deleteProject(@PathVariable UUID id) {
        projectService.deleteProjectById(id);

        return ResponseEntity.ok().build();
    }

}
