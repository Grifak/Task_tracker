package com.gr1fak.task_tracker.mapper;

import com.gr1fak.task_tracker.dto.request.UserRequestDto;
import com.gr1fak.task_tracker.dto.response.UserResponseDto;
import com.gr1fak.task_tracker.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseDto taskToResponseDto(UserEntity userEntity);
    UserEntity taskRequestDtoToTask(UserRequestDto requestDto);
}
