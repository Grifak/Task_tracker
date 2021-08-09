package com.gr1fak.taskTracker.mapper;

import com.gr1fak.taskTracker.dto.request.ReleaseRequestDto;
import com.gr1fak.taskTracker.dto.response.ReleaseResponseDto;
import com.gr1fak.taskTracker.model.ReleaseEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ReleaseMapper {

    ReleaseResponseDto releaseToResponseDto(ReleaseEntity releaseEntity);
    ReleaseEntity requestDtoToRelease(ReleaseRequestDto releaseRequestDto);
}
