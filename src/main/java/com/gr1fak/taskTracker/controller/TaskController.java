package com.gr1fak.taskTracker.controller;

import com.gr1fak.taskTracker.dto.request.TaskRequestDto;
import com.gr1fak.taskTracker.dto.response.TaskResponseDto;
import com.gr1fak.taskTracker.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/task")
@Tag(name = "Задачи")
@RestController
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Получить список задач")
    @GetMapping(value = "/tasks")
    public ResponseEntity<List<TaskResponseDto>> getTasks() {
        List<TaskResponseDto> tasks = taskService.getAll();
        return ResponseEntity.ok().body(tasks);
    }

    @Operation(summary = "Добавить задачу")
    @PostMapping(value = "/task")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto requestDto) {
        TaskResponseDto responseDto = taskService.addTask(requestDto);

        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Удаление задачи")
    @DeleteMapping(value = "/task/{id}")
    public ResponseEntity partialUpdateTask(@PathVariable UUID id) {
        taskService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
