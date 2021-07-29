package com.gr1fak.task_tracker.service;

import com.gr1fak.task_tracker.dto.request.ReleaseRequestDto;
import com.gr1fak.task_tracker.dto.response.ReleaseResponseDto;

import java.util.UUID;

public interface ReleaseService {
    ReleaseResponseDto getById(UUID id);
    ReleaseResponseDto addRelease(ReleaseRequestDto requestDto);
}
