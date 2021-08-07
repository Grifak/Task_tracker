package com.gr1fak.task_tracker.service.impl;

import com.gr1fak.task_tracker.dto.request.UserRequestDto;
import com.gr1fak.task_tracker.dto.response.UserResponseDto;
import com.gr1fak.task_tracker.model.UserEntity;
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
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    @Override
    public UserResponseDto getById(UUID id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("User with ID = %s not found", id))
        );

        return userMapper.taskToResponseDto(userEntity);
    }

    @Transactional
    @Override
    public UserResponseDto addUser(UserRequestDto requestDto) {
        UserEntity userEntity = userMapper.taskRequestDtoToTask(requestDto);
        userRepository.save(userEntity);
        return userMapper.taskToResponseDto(userEntity);
    }

    @Transactional
    @Override
    public void deleteUser(UUID id) {
        userRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(String.format("User with ID = %s not found", id))
        );

        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public UserResponseDto updateUser(UUID id, UserRequestDto requestDto) {
        UserEntity entity = userRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(String.format("User with ID = %s not found", id))
        );

        entity.setEmail(requestDto.getEmail());
        entity.setLogin(requestDto.getLogin());
        entity.setPassword(requestDto.getPassword());

        return userMapper.taskToResponseDto(entity);
    }
}
