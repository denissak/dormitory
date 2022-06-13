package by.sak.dormitory.service.impl;

import by.sak.dormitory.dto.ContractCreateUpdateDto;
import by.sak.dormitory.dto.ContractReadDto;
import by.sak.dormitory.mapper.ContractCreateUpdateMapper;
import by.sak.dormitory.mapper.ContractReadMapper;
import by.sak.dormitory.repository.ContractRepository;
import by.sak.dormitory.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final ContractReadMapper contractReadMapper;
    private final ContractCreateUpdateMapper contractCreateUpdateMapper;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository, ContractReadMapper contractReadMapper, ContractCreateUpdateMapper contractCreateUpdateMapper) {
        this.contractRepository = contractRepository;
        this.contractReadMapper = contractReadMapper;
        this.contractCreateUpdateMapper = contractCreateUpdateMapper;
    }

    @Override
    public List<ContractReadDto> findAll() {
        return contractRepository.findAll().stream().map(contractReadMapper::convertToContractReadDto).toList();
    }

    @Override
    public Optional<ContractReadDto> findById(Integer contractId) {
        return contractRepository.findById(contractId).map(contractReadMapper::convertToContractReadDto);
    }

    @Transactional
    @Override
    public ContractReadDto create(ContractCreateUpdateDto contractCreateUpdateDto) {
        return Optional.of(contractCreateUpdateDto)
                .map(contractCreateUpdateMapper::map)
                .map(contractRepository::save)
                .map(contractReadMapper::convertToContractReadDto)
                .orElseThrow();
    }

    @Transactional
    @Override
    public Optional<ContractReadDto> update(Integer id, ContractCreateUpdateDto contractCreateUpdateDto) {
        return contractRepository.findById(id).map(contract -> contractCreateUpdateMapper.map(contractCreateUpdateDto, contract))
                .map(contractRepository::saveAndFlush)
                .map(contractReadMapper::convertToContractReadDto);
    }

    @Transactional
    @Override
    public boolean delete(Integer id) {
        return contractRepository.findById(id).map(room -> {
                    contractRepository.delete(room);
                    contractRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
