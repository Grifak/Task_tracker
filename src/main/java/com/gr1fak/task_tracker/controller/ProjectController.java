package com.gr1fak.task_tracker.controller;

import com.gr1fak.task_tracker.dto.enums.ProjectStatus;
import com.gr1fak.task_tracker.dto.request.ProjectRequestDto;
import com.gr1fak.task_tracker.dto.response.ProjectResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;

@RequestMapping("/api/project")
@Tag(name = "Проект")
@RestController
public class ProjectController {
    @Operation(summary = "Получить проект")
    @GetMapping(value = "/project")
    public ResponseEntity<ProjectResponseDto> getRelease() {
        ProjectResponseDto project = new ProjectResponseDto("task-tacker", "cool project",
                ProjectStatus.STARTED, "Dmitriy");

        return ResponseEntity.ok().body(project);
    }

    @Operation(summary = "Добавить проект")
    @PostMapping(value = "/project")
    public ResponseEntity<ProjectResponseDto> createTask(@RequestBody ProjectRequestDto requestDto) {
        //TODO добавление

        return ResponseEntity.ok().body(new ProjectResponseDto(requestDto.getName(), requestDto.getDescription(),
                requestDto.getStatus(), requestDto.getCustomer()));
    }

    @Operation(summary = "Обновление проекта")
    @PutMapping(value = "/project/{id}")
    public ResponseEntity<ProjectResponseDto> partialUpdateTask(@PathVariable Long id,
                                                                @RequestBody ProjectRequestDto requestDto) {
        //TODO обновление сущности
        return ResponseEntity.ok().body(new ProjectResponseDto(requestDto.getName(), requestDto.getDescription(),
                requestDto.getStatus(), requestDto.getCustomer()));
    }

    @Operation(summary = "Удаление проекта")
    @DeleteMapping(value = "/project/{id}")
    public ResponseEntity partialUpdateTask(@PathVariable Long id) {
        //TODO удаление сущности

        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
