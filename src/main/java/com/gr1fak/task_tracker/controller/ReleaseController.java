package com.gr1fak.task_tracker.controller;

import com.gr1fak.task_tracker.dto.request.ReleaseRequestDto;
import com.gr1fak.task_tracker.dto.response.ReleaseResponseDto;
import com.gr1fak.task_tracker.mapper.ReleaseMapper;
import com.gr1fak.task_tracker.service.ReleaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javassist.NotFoundException;
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
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/release")
@Tag(name = "Версии")
@RestController
public class ReleaseController {
    private final ReleaseService releaseService;

    @Autowired
    public ReleaseController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @Operation(summary = "Получить список версий")
    @GetMapping(value = "/releases")
    public ResponseEntity<List<ReleaseResponseDto>> getReleases() {
        List<ReleaseResponseDto> result = releaseService.getAll();
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Добавить версию")
    @PostMapping(value = "/release")
    public ResponseEntity<ReleaseResponseDto> createRelease(@RequestBody ReleaseRequestDto requestDto) {
        ReleaseResponseDto responseDto = releaseService.addRelease(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Обновление версии")
    @PutMapping(value = "/release/{id}")
    public ResponseEntity<ReleaseResponseDto> partialUpdateRelease(@PathVariable UUID id,
                                                             @RequestBody ReleaseRequestDto requestDto) {
        ReleaseResponseDto responseDto = releaseService.updateRelease(id, requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @Operation(summary = "Удаление версии")
    @DeleteMapping(value = "/release/{id}")
    public ResponseEntity deleteRelease(@PathVariable UUID id) {
        releaseService.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
