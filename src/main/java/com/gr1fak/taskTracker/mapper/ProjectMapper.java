package com.gr1fak.taskTracker.mapper;

import com.gr1fak.taskTracker.dto.request.ProjectRequestDto;
import com.gr1fak.taskTracker.dto.response.ProjectResponseDto;
import com.gr1fak.taskTracker.model.ProjectEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProjectMapper {

    ProjectResponseDto projectToResponseDto(ProjectEntity projectEntity);
    ProjectEntity requestDtoToProject(ProjectRequestDto projectRequestDto);
}
