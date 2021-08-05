package com.gr1fak.task_tracker.mapper;

import com.gr1fak.task_tracker.dto.request.ProjectRequestDto;
import com.gr1fak.task_tracker.dto.response.ProjectResponseDto;
import com.gr1fak.task_tracker.model.ProjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    ProjectResponseDto projectToResponseDto(ProjectEntity projectEntity);
    ProjectEntity requestDtoToProject(ProjectRequestDto projectRequestDto);
}
