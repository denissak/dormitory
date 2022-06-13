package by.sak.dormitory.service.impl;

import by.sak.dormitory.dto.WorkCreateUpdateDto;
import by.sak.dormitory.dto.WorkReadDto;
import by.sak.dormitory.mapper.WorkCreateUpdateMapper;
import by.sak.dormitory.mapper.WorkReadMapper;
import by.sak.dormitory.repository.WorkPlaceRepository;
import by.sak.dormitory.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class WorkServiceImpl implements WorkService {

    private final WorkPlaceRepository workPlaceRepository;
    private final WorkReadMapper workReadMapper;
    private final WorkCreateUpdateMapper workCreateUpdateMapper;

    @Autowired
    public WorkServiceImpl(WorkPlaceRepository workPlaceRepository, WorkReadMapper workReadMapper, WorkCreateUpdateMapper workCreateUpdateMapper) {
        this.workPlaceRepository = workPlaceRepository;
        this.workReadMapper = workReadMapper;
        this.workCreateUpdateMapper = workCreateUpdateMapper;
    }

    @Override
    public List<WorkReadDto> findAll() {
        return workPlaceRepository.findAll().stream().map(workReadMapper::convertToWorkPlaceReadDto).toList();
    }

    @Override
    public Optional<WorkReadDto> findById(Integer workId) {
        return workPlaceRepository.findById(workId).map(workReadMapper::convertToWorkPlaceReadDto);
    }

    @Transactional
    @Override
    public WorkReadDto create(WorkCreateUpdateDto workCreateUpdateDto) {
        return Optional.of(workCreateUpdateDto)
                .map(workCreateUpdateMapper::map)
                .map(workPlaceRepository::save)
                .map(workReadMapper::convertToWorkPlaceReadDto)
                .orElseThrow();
    }

    @Transactional
    @Override
    public Optional<WorkReadDto> update(Integer id, WorkCreateUpdateDto workCreateUpdateDto) {
        return workPlaceRepository.findById(id).map(workPlace -> workCreateUpdateMapper.map(workCreateUpdateDto, workPlace))
                .map(workPlaceRepository::saveAndFlush)
                .map(workReadMapper::convertToWorkPlaceReadDto);
    }

    @Transactional
    @Override
    public boolean delete(Integer id) {
        return workPlaceRepository.findById(id).map(workPlace -> {
                    workPlaceRepository.delete(workPlace);
                    workPlaceRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
