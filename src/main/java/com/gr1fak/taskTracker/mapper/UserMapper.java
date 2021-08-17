package com.gr1fak.taskTracker.mapper;

import com.gr1fak.taskTracker.dto.request.UserRequestDto;
import com.gr1fak.taskTracker.dto.response.UserResponseDto;
import com.gr1fak.taskTracker.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    @Autowired
    protected PasswordEncoder passwordEncoder;

    public abstract UserResponseDto taskToResponseDto(UserEntity userEntity);
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(requestDto.getPassword()))")
    public abstract UserEntity taskRequestDtoToTask(UserRequestDto requestDto);
}
