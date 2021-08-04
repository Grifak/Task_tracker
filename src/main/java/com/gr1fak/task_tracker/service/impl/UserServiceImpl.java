package com.gr1fak.task_tracker.service.impl;

import com.gr1fak.task_tracker.dto.request.UserRequestDto;
import com.gr1fak.task_tracker.dto.response.UserResponseDto;
import com.gr1fak.task_tracker.entities.UserEntity;
import com.gr1fak.task_tracker.mapper.UserMapper;
import com.gr1fak.task_tracker.repository.UserRepository;
import com.gr1fak.task_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UserResponseDto getById(UUID id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("User with ID = %d not found", id))
        );

        return UserMapper.INSTANCE.taskToResponseDto(userEntity);
    }

    @Transactional
    @Override
    public UserResponseDto addUser(UserRequestDto requestDto) {
        UserEntity userEntity = UserMapper.INSTANCE.taskRequestDtoToTask(requestDto);
        userRepository.save(userEntity);
        return UserMapper.INSTANCE.taskToResponseDto(userEntity);
    }

    @Transactional
    @Override
    public void deleteUser(UUID id) {
        userRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(String.format("User with ID = %d not found", id))
        );

        userRepository.deleteById(id);
    }
}
