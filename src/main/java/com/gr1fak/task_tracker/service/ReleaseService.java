package com.gr1fak.task_tracker.service;

import com.gr1fak.task_tracker.dto.request.ReleaseRequestDto;
import com.gr1fak.task_tracker.dto.response.ReleaseResponseDto;

import java.util.List;
import java.util.UUID;

public interface ReleaseService {
    List<ReleaseResponseDto> getAll();
    ReleaseResponseDto addRelease(ReleaseRequestDto requestDto);
    void deleteById(UUID id);
}
