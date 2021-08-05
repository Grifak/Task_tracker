package com.gr1fak.task_tracker.mapper;

import com.gr1fak.task_tracker.dto.request.ReleaseRequestDto;
import com.gr1fak.task_tracker.dto.response.ReleaseResponseDto;
import com.gr1fak.task_tracker.model.ReleaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReleaseMapper {
    ReleaseMapper INSTANCE = Mappers.getMapper(ReleaseMapper.class);

    ReleaseResponseDto releaseToResponseDto(ReleaseEntity releaseEntity);
    ReleaseEntity requestDtoToRelease(ReleaseRequestDto releaseRequestDto);
}
