package com.gr1fak.taskTracker.mapper;

import com.gr1fak.taskTracker.dto.request.UserRequestDto;
import com.gr1fak.taskTracker.dto.response.UserResponseDto;
import com.gr1fak.taskTracker.model.UserEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto taskToResponseDto(UserEntity userEntity);
    UserEntity taskRequestDtoToTask(UserRequestDto requestDto);
}
