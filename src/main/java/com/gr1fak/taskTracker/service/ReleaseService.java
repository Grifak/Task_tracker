package com.gr1fak.taskTracker.service;

import com.gr1fak.taskTracker.dto.request.ReleaseRequestDto;
import com.gr1fak.taskTracker.dto.response.ReleaseResponseDto;

import java.util.List;
import java.util.UUID;

public interface ReleaseService {
    List<ReleaseResponseDto> getAll();
    ReleaseResponseDto addRelease(ReleaseRequestDto requestDto);
    void deleteById(UUID id);
    ReleaseResponseDto updateRelease(UUID id, ReleaseRequestDto requestDto);
}
