package com.gr1fak.task_tracker.service.impl;

import com.gr1fak.task_tracker.dto.request.UserRequestDto;
import com.gr1fak.task_tracker.dto.response.UserResponseDto;
import com.gr1fak.task_tracker.entities.UserEntity;
import com.gr1fak.task_tracker.repository.UserRepository;
import com.gr1fak.task_tracker.service.UserService;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto getById(UUID id) {
        UserEntity usereEntity = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User with ID = " + id +" not found")
        );

        UserResponseDto responseDto = new UserResponseDto();
        //TODO mapStruct userEntityToUserResponseDto
        return responseDto;
    }

    @Override
    public UserResponseDto addUser(UserRequestDto requestDto) {
        UserEntity userEntity = new UserEntity();
        //TODO mapStruct UserRequestDtoToUserEntity
        UserResponseDto responseDto = new UserResponseDto();
        //TODO mapStruct UserEntityToUserResponseDto
        return responseDto;
    }
}
