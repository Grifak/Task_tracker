package com.gr1fak.taskTracker.service;

import com.gr1fak.taskTracker.dto.request.UserRequestDto;
import com.gr1fak.taskTracker.dto.response.UserResponseDto;

import java.util.UUID;

public interface UserService {
    UserResponseDto getById(UUID id);
    UserResponseDto addUser(UserRequestDto requestDto);
    void deleteUser(UUID id);
    UserResponseDto updateUser(UUID id, UserRequestDto requestDto);
}
