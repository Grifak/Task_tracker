package com.gr1fak.task_tracker.service.impl;

import com.gr1fak.task_tracker.dto.request.ReleaseRequestDto;
import com.gr1fak.task_tracker.dto.response.ReleaseResponseDto;
import com.gr1fak.task_tracker.entities.ReleaseEntity;
import com.gr1fak.task_tracker.repository.ReleaseRepository;
import com.gr1fak.task_tracker.service.ReleaseService;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.UUID;

@Service
public class ReleaseServiceImpl implements ReleaseService {

    private ReleaseRepository releaseRepository;

    public ReleaseServiceImpl(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    @Override
    public ReleaseResponseDto getById(UUID id) {
        ReleaseEntity releaseEntity = releaseRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Release with ID = " + id +" not found")
        );
        ReleaseResponseDto responseDto = new ReleaseResponseDto();
        //TODO mapStruct ReleaseEntityToReleaseResponseDto
        return responseDto;
    }

    @Override
    public ReleaseResponseDto addRelease(ReleaseRequestDto requestDto) {
        ReleaseEntity releaseEntity = new ReleaseEntity();
        //TODO mapStruct ReleaserequestDtoToReleaseEntity
        ReleaseResponseDto responseDto = new ReleaseResponseDto();
        //TODO mapStruct ReleaseEntityToReleaseResponseDto
        return responseDto;
    }
}
