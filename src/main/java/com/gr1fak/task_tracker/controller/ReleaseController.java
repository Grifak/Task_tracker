package com.gr1fak.task_tracker.controller;

import com.gr1fak.task_tracker.dto.request.ReleaseRequestDto;
import com.gr1fak.task_tracker.dto.response.ReleaseResponseDto;
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
import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api/releases")
@Tag(name = "Версии")
@RestController
public class ReleaseController {
    @Operation(summary = "Получить список версий")
    @GetMapping(value = "/release")
    public ResponseEntity<List<ReleaseResponseDto>> getRelease() {
        ReleaseResponseDto release1 = new ReleaseResponseDto("release1", LocalDateTime.now(),
                LocalDateTime.now());
        ReleaseResponseDto release2 = new ReleaseResponseDto("release2", LocalDateTime.now(),
                LocalDateTime.now());

        List<ReleaseResponseDto> results =  List.of(release1, release2);
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Добавить версию")
    @PostMapping(value = "/release")
    public ResponseEntity<ReleaseResponseDto> createTask(@RequestBody ReleaseRequestDto requestDto) {
        //TODO добавление

        return ResponseEntity.ok().body(new ReleaseResponseDto(requestDto.getName(), requestDto.getBegin(),
                requestDto.getEnd()));
    }

    @Operation(summary = "Обновление версии")
    @PutMapping(value = "/release/{id}")
    public ResponseEntity<ReleaseResponseDto> partialUpdateTask(@PathVariable Long id,
                                                             @RequestBody ReleaseRequestDto requestDto) {
        //TODO обновление сущности
        return ResponseEntity.ok().body(new ReleaseResponseDto(requestDto.getName(), requestDto.getBegin(),
                requestDto.getEnd()));
    }

    @Operation(summary = "Удаление версии")
    @DeleteMapping(value = "/release/{id}")
    public ResponseEntity partialUpdateTask(@PathVariable Long id) {
        //TODO удаление сущности

        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
