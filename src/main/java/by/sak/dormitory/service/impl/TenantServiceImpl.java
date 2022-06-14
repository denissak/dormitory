package by.sak.dormitory.service.impl;

import by.sak.dormitory.dto.TenantCreateUpdateDto;
import by.sak.dormitory.dto.TenantReadDto;
import by.sak.dormitory.mapper.TenantCreateUpdateMapper;
import by.sak.dormitory.mapper.TenantReadMapper;
import by.sak.dormitory.repository.TenantRepository;
import by.sak.dormitory.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;
    private final TenantReadMapper tenantReadMapper;
    private final TenantCreateUpdateMapper tenantCreateUpdateMapper;

    @Autowired
    public TenantServiceImpl(TenantRepository tenantRepository, TenantReadMapper tenantReadMapper, TenantCreateUpdateMapper tenantCreateUpdateMapper) {
        this.tenantRepository = tenantRepository;
        this.tenantReadMapper = tenantReadMapper;
        this.tenantCreateUpdateMapper = tenantCreateUpdateMapper;
    }

    @Override
    public List<TenantReadDto> findAll() {
        return tenantRepository.findAll().stream().map(tenantReadMapper::convertToTenantReadDto).toList();
    }

    @Override
    public Optional<TenantReadDto> findById(Integer tenantId) {
        return tenantRepository.findById(tenantId).map(tenantReadMapper::convertToTenantReadDto);
    }

    @Override
    public TenantReadDto create(TenantCreateUpdateDto tenantCreateUpdateDto) {
        return Optional.of(tenantCreateUpdateDto)
                .map(tenantCreateUpdateMapper::map)
                .map(tenantRepository::save)
                .map(tenantReadMapper::convertToTenantReadDto)
                .orElseThrow();
    }

    @Override
    public Optional<TenantReadDto> update(Integer id, TenantCreateUpdateDto tenantCreateUpdateDto) {
        return tenantRepository.findById(id).map(user -> tenantCreateUpdateMapper.map(tenantCreateUpdateDto, user))
                .map(tenantRepository::saveAndFlush)
                .map(tenantReadMapper::convertToTenantReadDto);
    }

    @Override
    public boolean delete(Integer id) {
        return tenantRepository.findById(id).map(room -> {
                    tenantRepository.delete(room);
                    tenantRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
