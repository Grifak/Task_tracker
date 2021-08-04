package com.gr1fak.task_tracker.service;

import com.gr1fak.task_tracker.dto.request.UserRequestDto;
import com.gr1fak.task_tracker.dto.response.UserResponseDto;

import java.util.UUID;

public interface UserService {
    UserResponseDto getById(UUID id);
    UserResponseDto addUser(UserRequestDto requestDto);
    void deleteUser(UUID id);
}
