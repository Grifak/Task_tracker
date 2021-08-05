package com.gr1fak.task_tracker.mapper;

import com.gr1fak.task_tracker.dto.request.TaskRequestDto;
import com.gr1fak.task_tracker.dto.response.TaskResponseDto;
import com.gr1fak.task_tracker.model.TaskEntity;
import com.gr1fak.task_tracker.repository.ProjectRepository;
import com.gr1fak.task_tracker.repository.ReleaseRepository;
import com.gr1fak.task_tracker.repository.TaskRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", uses = {TaskRepository.class, ProjectRepository.class,
        ReleaseRepository.class})
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);


    TaskResponseDto taskToResponseDto(TaskEntity taskEntity);
    @Mappings({
            @Mapping(target = "author", ignore = true),
            @Mapping(target = "project", ignore = true),
            @Mapping(target = "release", ignore = true)
    })
    TaskEntity taskRequestDtoToTask(TaskRequestDto requestDto, @Context TaskContext ctx);
}
