package com.gr1fak.task_tracker.mapper;

import com.gr1fak.task_tracker.dto.request.TaskRequestDto;
import com.gr1fak.task_tracker.model.ProjectEntity;
import com.gr1fak.task_tracker.model.ReleaseEntity;
import com.gr1fak.task_tracker.model.TaskEntity;
import com.gr1fak.task_tracker.model.UserEntity;
import com.gr1fak.task_tracker.repository.ProjectRepository;
import com.gr1fak.task_tracker.repository.ReleaseRepository;
import com.gr1fak.task_tracker.repository.UserRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.webjars.NotFoundException;

import java.util.UUID;

public class TaskContext {
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final ReleaseRepository releaseRepository;

    private TaskRequestDto requestDto;
    private UserEntity userEntity;
    private ProjectEntity projectEntity;
    private ReleaseEntity releaseEntity;

    public TaskContext(UserRepository userRepository,
                       ProjectRepository projectRepository, ReleaseRepository releaseRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.releaseRepository = releaseRepository;
    }

    @BeforeMapping
    public void setRequestDto(@MappingTarget TaskRequestDto requestDto) {
        this.requestDto = requestDto;
    }

    @BeforeMapping
    public void setEntities(){
        this.userEntity = userRepository.findById(requestDto.getAuthorId()).orElse(null);
        this.projectEntity = projectRepository.findById(requestDto.getProjectId()).orElse(null);
        this.releaseEntity = releaseRepository.findById(requestDto.getReleaseId()).orElse(null);
    }

    @AfterMapping
    public void establishRelation(@MappingTarget TaskEntity taskEntity){
        taskEntity.setAuthor(userEntity);
        taskEntity.setProject(projectEntity);
        taskEntity.setRelease(releaseEntity);
    }
}
