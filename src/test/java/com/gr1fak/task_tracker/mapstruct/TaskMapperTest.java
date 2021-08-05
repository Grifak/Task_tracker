package com.gr1fak.task_tracker.mapstruct;

import com.gr1fak.task_tracker.dto.request.TaskRequestDto;
import com.gr1fak.task_tracker.enums.TaskStatus;
import com.gr1fak.task_tracker.mapper.TaskContext;
import com.gr1fak.task_tracker.mapper.TaskMapper;
import com.gr1fak.task_tracker.model.TaskEntity;
import com.gr1fak.task_tracker.repository.ProjectRepository;
import com.gr1fak.task_tracker.repository.ReleaseRepository;
import com.gr1fak.task_tracker.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class TaskMapperTest {
    private UserRepository userRepository;
    private ProjectRepository projectRepository;
    private ReleaseRepository releaseRepository;

    @Autowired
    public TaskMapperTest(UserRepository userRepository,
                          ProjectRepository projectRepository, ReleaseRepository releaseRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.releaseRepository = releaseRepository;
    }

    @Test
    void testToEntity() {
        TaskRequestDto requestDto = new TaskRequestDto();
        requestDto.setName("do");
        requestDto.setStatus(TaskStatus.DONE);
        requestDto.setAuthorId(UUID.fromString("8bc34850-04c6-456f-8b16-47d254384b3a"));
        requestDto.setReleaseId(UUID.fromString("2fe6d848-e896-4997-88cc-cd4d2aca5b40"));
        requestDto.setProjectId(UUID.fromString("a48cbb21-38af-4678-a506-800ab18b36bb"));

        TaskContext taskCtx = new TaskContext(userRepository, projectRepository, releaseRepository);

        TaskEntity taskEntity = TaskMapper.INSTANCE.taskRequestDtoToTask(requestDto, taskCtx);

        
    }
}
