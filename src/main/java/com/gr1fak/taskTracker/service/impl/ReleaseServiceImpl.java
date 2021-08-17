package com.gr1fak.taskTracker.service.impl;

import com.gr1fak.taskTracker.dto.request.ReleaseRequestDto;
import com.gr1fak.taskTracker.dto.response.ReleaseResponseDto;
import com.gr1fak.taskTracker.model.ReleaseEntity;
import com.gr1fak.taskTracker.mapper.ReleaseMapper;
import com.gr1fak.taskTracker.repository.ReleaseRepository;
import com.gr1fak.taskTracker.service.ReleaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReleaseServiceImpl implements ReleaseService {
    private ReleaseRepository releaseRepository;
    private ReleaseMapper releaseMapper;

    public ReleaseServiceImpl(ReleaseRepository releaseRepository, ReleaseMapper releaseMapper) {
        this.releaseRepository = releaseRepository;
        this.releaseMapper = releaseMapper;
    }

    @Transactional
    @Override
    public List<ReleaseResponseDto> getAll() {
        List<ReleaseEntity> releaseEntities = releaseRepository.findAll();
        List<ReleaseResponseDto> responseDtoList = new ArrayList<>();

        releaseEntities.stream().
                forEach(r->responseDtoList.add(releaseMapper.releaseToResponseDto(r)));

        return responseDtoList;
    }

    @Transactional
    @Override
    public ReleaseResponseDto addRelease(ReleaseRequestDto requestDto) {
        ReleaseEntity releaseEntity = releaseMapper.requestDtoToRelease(requestDto);
        releaseRepository.save(releaseEntity);

        return releaseMapper.releaseToResponseDto(releaseEntity);
    }

    @Transactional
    @Override
    public void deleteById(UUID id) {
        releaseRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Release with ID = %s not found", id))
        );

        releaseRepository.deleteById(id);
    }

    @Transactional
    @Override
    public ReleaseResponseDto updateRelease(UUID id, ReleaseRequestDto requestDto) {
        ReleaseEntity releaseEntity = releaseRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Release with ID = %s not found", id))
        );

        releaseEntity.setName(requestDto.getName());
        releaseEntity.setEnd(requestDto.getEnd());
        releaseEntity.setBegin(requestDto.getBegin());

        return releaseMapper.releaseToResponseDto(releaseEntity);
    }
}
