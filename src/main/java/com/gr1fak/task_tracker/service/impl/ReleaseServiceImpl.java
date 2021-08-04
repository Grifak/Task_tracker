package com.gr1fak.task_tracker.service.impl;

import com.gr1fak.task_tracker.dto.request.ReleaseRequestDto;
import com.gr1fak.task_tracker.dto.response.ReleaseResponseDto;
import com.gr1fak.task_tracker.entities.ReleaseEntity;
import com.gr1fak.task_tracker.mapper.ReleaseMapper;
import com.gr1fak.task_tracker.repository.ReleaseRepository;
import com.gr1fak.task_tracker.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReleaseServiceImpl implements ReleaseService {
    private ReleaseRepository releaseRepository;

    @Autowired
    public ReleaseServiceImpl(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    @Transactional
    @Override
    public List<ReleaseResponseDto> getAll() {
        List<ReleaseEntity> releaseEntities = releaseRepository.findAll();
        List<ReleaseResponseDto> responseDtoList = new ArrayList<>();

        for(ReleaseEntity releaseEntity: releaseEntities){
            responseDtoList.add(ReleaseMapper.INSTANCE.releaseToResponseDto(releaseEntity));
        }

        return responseDtoList;
    }

    @Transactional
    @Override
    public ReleaseResponseDto addRelease(ReleaseRequestDto requestDto) {
        ReleaseEntity releaseEntity = ReleaseMapper.INSTANCE.requestDtoToRelease(requestDto);
        releaseRepository.save(releaseEntity);

        return ReleaseMapper.INSTANCE.releaseToResponseDto(releaseEntity);
    }

    @Transactional
    @Override
    public void deleteById(UUID id) {
        releaseRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Release with ID = %d not found", id))
        );

        releaseRepository.deleteById(id);
    }
}
