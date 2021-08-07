package com.gr1fak.task_tracker.mapper;

import com.gr1fak.task_tracker.dto.request.TaskRequestDto;
import com.gr1fak.task_tracker.dto.response.TaskResponseDto;
import com.gr1fak.task_tracker.model.TaskEntity;
import com.gr1fak.task_tracker.repository.ProjectRepository;
import com.gr1fak.task_tracker.repository.ReleaseRepository;
import com.gr1fak.task_tracker.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class TaskMapper {
    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected ProjectRepository projectRepository;
    @Autowired
    protected ReleaseRepository releaseRepository;

    public abstract TaskResponseDto taskToResponseDto(TaskEntity entity);

    public TaskEntity taskRequestDtoToTask(TaskRequestDto requestDto){
        TaskEntity entity = new TaskEntity();
        entity.setName(requestDto.getName());
        entity.setStatus(requestDto.getStatus());
        entity.setAuthor(userRepository.findById(requestDto.getAuthorId()).orElse(null));
        entity.setRelease(releaseRepository.findById(requestDto.getReleaseId()).orElse(null));
        entity.setProject(projectRepository.findById(requestDto.getProjectId()).orElse(null));

        return entity;
    }
}
