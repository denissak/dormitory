package by.sak.dormitory.service.impl;

import by.sak.dormitory.dto.ManagerCreateUpdateDto;
import by.sak.dormitory.dto.ManagerReadDto;
import by.sak.dormitory.mapper.ManagerReadMapper;
import by.sak.dormitory.mapper.ManagerUpdateMapper;
import by.sak.dormitory.repository.ManagerRepository;
import by.sak.dormitory.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;
    private final ManagerReadMapper managerReadMapper;
    private final ManagerUpdateMapper managerUpdateMapper;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository, ManagerReadMapper managerReadMapper, ManagerUpdateMapper managerUpdateMapper) {
        this.managerRepository = managerRepository;
        this.managerReadMapper = managerReadMapper;
        this.managerUpdateMapper = managerUpdateMapper;
    }

    @Override
    public Optional<ManagerReadDto> findById(Integer managerId) {
        return managerRepository.findById(managerId).map(managerReadMapper::convertToManagerReadDto);
    }

    @Transactional
    @Override
    public Optional<ManagerReadDto> update(Integer id, ManagerCreateUpdateDto managerDto) {
        return managerRepository.findById(id).map(manager -> managerUpdateMapper.map(managerDto, manager))
                .map(managerRepository::saveAndFlush)
                .map(managerReadMapper::convertToManagerReadDto);
    }
}
