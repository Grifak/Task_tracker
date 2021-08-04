package com.gr1fak.task_tracker.controller;

import com.gr1fak.task_tracker.dto.request.TaskRequestDto;
import com.gr1fak.task_tracker.dto.response.TaskResponseDto;
import com.gr1fak.task_tracker.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.List;

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

    @Operation(summary = "Обновление задачи")
    @PutMapping(value = "/task/{id}")
    public ResponseEntity<TaskResponseDto> partialUpdateTask(@PathVariable Long id,
                                                             @RequestBody TaskRequestDto requestDto) {
        //TODO обновление сущности
        return ResponseEntity.ok().body(new TaskResponseDto(requestDto.getName(), requestDto.getStatus()));
    }

    @Operation(summary = "Удаление задачи")
    @DeleteMapping(value = "/task/{id}")
    public ResponseEntity partialUpdateTask(@PathVariable Long id) {


        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
