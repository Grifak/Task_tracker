package com.gr1fak.taskTracker.controller;

import com.gr1fak.taskTracker.dto.response.TaskResponseDto;
import com.gr1fak.taskTracker.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Управление задачей")
@RequestMapping("api/task/management")
@RestController
public class TaskManagementController {
    private TaskService taskService;

    public TaskManagementController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Назначение исполнителя")
    @PreAuthorize("hasAuthority('user:write')")
    @PutMapping("/executor/{taskId}")
    public ResponseEntity<TaskResponseDto> updateExecutor(@PathVariable UUID taskId,
                                                           @RequestParam UUID userId){
        TaskResponseDto responseDto = taskService.setExecutor(taskId, userId);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Установка релиза")
    @PreAuthorize("hasAuthority('user:write')")
    @PutMapping("/release/{taskId}")
    public ResponseEntity<TaskResponseDto> updateRelease(@PathVariable UUID taskId,
                                                        @RequestParam UUID releaseId){
        TaskResponseDto responseDto = taskService.setRelease(taskId, releaseId);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Смена статуса задачи")
    @PreAuthorize("hasAuthority('user:write')")
    @PutMapping("/status/{id}")
    public ResponseEntity<TaskResponseDto> changeStatus(@PathVariable UUID id,
                                                        @RequestParam String status){
        TaskResponseDto responseDto = taskService.setStatus(id, status);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Подсчет задач не завршившихся в заданном релизе")
    @PreAuthorize("hasAuthority('user:write')")
    @GetMapping("/task/{releaseId}")
    public ResponseEntity<Integer> countingIncompleteTask(@PathVariable UUID releaseId){
        Integer count = taskService.countIncompleteTaskInRelease(releaseId);

        return ResponseEntity.ok().body(count);
    }
}
