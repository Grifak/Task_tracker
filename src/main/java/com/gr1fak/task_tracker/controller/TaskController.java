package com.gr1fak.task_tracker.controller;

import com.gr1fak.task_tracker.model.dto.enums.TaskStatus;
import com.gr1fak.task_tracker.model.dto.request.TaskRequestDto;
import com.gr1fak.task_tracker.model.dto.response.TaskResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Tag(name = "Задачи")
@RestController
public class TaskController {
    @Operation(summary = "Получить список задач")
    @GetMapping(value = "/project")
    public ResponseEntity<List<TaskResponseDto>> getTasks() {
        TaskResponseDto task = new TaskResponseDto("task1", TaskStatus.IN_PROGRESS);
        TaskResponseDto task2 = new TaskResponseDto("task2", TaskStatus.BACKLOG);

        List<TaskResponseDto> results =  List.of(task, task2);
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Добавить задачу")
    @PostMapping(value = "/project")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto requestDto) {
        //TODO добавление

        return ResponseEntity.ok().body(new TaskResponseDto(requestDto.getName(), requestDto.getStatus()));
    }

    @Operation(summary = "Обновление задачи")
    @PutMapping(value = "/project/{id}")
    public ResponseEntity<TaskResponseDto> partialUpdateTask(@PathVariable Long id,
                                                             @RequestBody TaskRequestDto requestDto) {
        //TODO обновление сущности
        return ResponseEntity.ok().body(new TaskResponseDto(requestDto.getName(), requestDto.getStatus()));
    }

    @Operation(summary = "Удаление задачи")
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
