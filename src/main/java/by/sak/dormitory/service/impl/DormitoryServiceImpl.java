package by.sak.dormitory.service.impl;

import by.sak.dormitory.dto.DormitoryCreateUpdateDto;
import by.sak.dormitory.dto.DormitoryReadDto;
import by.sak.dormitory.mapper.DormitoryCreateUpdateMapper;
import by.sak.dormitory.mapper.DormitoryReadMapper;
import by.sak.dormitory.repository.DormitoryRepository;
import by.sak.dormitory.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DormitoryServiceImpl implements DormitoryService {

    private final DormitoryRepository dormitoryRepository;
    private final DormitoryReadMapper dormitoryReadMapper;
    private final DormitoryCreateUpdateMapper dormitoryCreateUpdateMapper;

    @Autowired
    public DormitoryServiceImpl(DormitoryRepository dormitoryRepository, DormitoryReadMapper dormitoryReadMapper, DormitoryCreateUpdateMapper dormitoryCreateUpdateMapper) {
        this.dormitoryRepository = dormitoryRepository;
        this.dormitoryReadMapper = dormitoryReadMapper;
        this.dormitoryCreateUpdateMapper = dormitoryCreateUpdateMapper;
    }

    @Override
    public List<DormitoryReadDto> findAll() {
        return dormitoryRepository.findAll().stream().map(dormitoryReadMapper::convertToDormitoryReadDto).toList();
    }

    @Override
    public Optional<DormitoryReadDto> findById(Integer dormitoryId) {
        return dormitoryRepository.findById(dormitoryId).map(dormitoryReadMapper::convertToDormitoryReadDto);
    }

    @Transactional
    @Override
    public DormitoryReadDto create(DormitoryCreateUpdateDto dormitory) {
        return Optional.of(dormitory)
                .map(dormitoryCreateUpdateMapper::map)
                .map(dormitoryRepository::save)
                .map(dormitoryReadMapper::convertToDormitoryReadDto)
                .orElseThrow();
    }

    @Transactional
    @Override
    public Optional<DormitoryReadDto> update(Integer id, DormitoryCreateUpdateDto dormitory) {
        return dormitoryRepository.findById(id).map(entity -> dormitoryCreateUpdateMapper.map(dormitory, entity))
                .map(dormitoryRepository::saveAndFlush)
                .map(dormitoryReadMapper::convertToDormitoryReadDto);
    }

    @Transactional
    @Override
    public boolean delete(Integer id) {
        return dormitoryRepository.findById(id).map(dormitory -> {
                    dormitoryRepository.delete(dormitory);
                    dormitoryRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
