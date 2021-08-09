package com.gr1fak.taskTracker.controller;

import com.gr1fak.taskTracker.dto.response.ProjectResponseDto;
import com.gr1fak.taskTracker.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "Управление проектом")
@RequestMapping("api/management/project")
@RestController
public class ProjectManagementController {
    private ProjectService projectService;

    @Autowired
    public ProjectManagementController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Operation()
    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponseDto> finishProject(@PathVariable UUID id){
        ProjectResponseDto responseDto = projectService.finishProject(id);

        return ResponseEntity.ok().body(responseDto);
    }
}
