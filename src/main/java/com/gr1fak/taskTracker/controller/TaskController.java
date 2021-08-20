package com.gr1fak.taskTracker.controller;

import com.gr1fak.taskTracker.dto.request.TaskRequestDto;
import com.gr1fak.taskTracker.dto.response.TaskResponseDto;
import com.gr1fak.taskTracker.enums.TaskStatus;
import com.gr1fak.taskTracker.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/task")
@Tag(name = "Задачи")
@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Получить список задач")
    @PreAuthorize("hasAuthority('user:read')")
    @GetMapping(value = "/tasks")
    public ResponseEntity<List<TaskResponseDto>> getTasks() {
        List<TaskResponseDto> tasks = taskService.getAll();
        return ResponseEntity.ok().body(tasks);
    }

    @Operation(summary = "Найти задачу по парматрам")
    @PreAuthorize("hasAuthority('user:read')")
    @GetMapping("/find")
    public ResponseEntity<List<TaskResponseDto>> findTasks(@RequestParam(required = false) String name,
                                                           @RequestParam(required = false) TaskStatus status){
        List<TaskResponseDto> response = taskService.findTasks(name, status);

        return ResponseEntity.ok().body(response);
    }

}
