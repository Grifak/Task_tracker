package com.gr1fak.task_tracker.mapper;

import com.gr1fak.task_tracker.dto.request.TaskRequestDto;
import com.gr1fak.task_tracker.dto.response.TaskResponseDto;
import com.gr1fak.task_tracker.entities.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskResponseDto taskToResponseDto(TaskEntity taskEntity);
    @Mappings({
            @Mapping(target = "name", source = "requestDto.name"),
            @Mapping(target = "status", source = "requestDto.status"),
            @Mapping(target = "author", source = "requestDto.author"),
            @Mapping(target = "project", source = "requestDto.project"),
            @Mapping(target = "release", source = "requestDto.release")
    })
    TaskEntity taskRequestDtoToTask(TaskRequestDto requestDto);
}
