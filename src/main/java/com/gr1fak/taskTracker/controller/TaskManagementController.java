package com.gr1fak.taskTracker.controller;

import com.gr1fak.taskTracker.dto.response.TaskResponseDto;
import com.gr1fak.taskTracker.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Управление задачей")
@RequestMapping("api/task/management")
@RestController
public class TaskManagementController {
    private TaskService taskService;

    @Autowired
    public TaskManagementController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Назначение исполнителя")
    @PutMapping("/executor/{taskId}")
    public ResponseEntity<TaskResponseDto> updateExecutor(@PathVariable UUID taskId,
                                                           @RequestParam UUID userId){
        TaskResponseDto responseDto = taskService.setExecutor(taskId, userId);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Установка релиза")
    @PutMapping("/release/{taskId}")
    public ResponseEntity<TaskResponseDto> updateRelease(@PathVariable UUID taskId,
                                                        @RequestParam UUID releaseId){
        TaskResponseDto responseDto = taskService.setRelease(taskId, releaseId);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Смена статуса задачи")
    @PutMapping("/status/{id}")
    public ResponseEntity<TaskResponseDto> changeStatus(@PathVariable UUID id,
                                                        @RequestParam String status){
        TaskResponseDto responseDto = taskService.setStatus(id, status);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Подсчет задач не завршившихся в заданном релизе")
    @GetMapping("/task/{releaseId}")
    public ResponseEntity<Integer> countingIncompleteTask(@PathVariable UUID releaseId){
        Integer count = taskService.countIncompleteTaskInRelease(releaseId);

        return ResponseEntity.ok().body(count);
    }
}
