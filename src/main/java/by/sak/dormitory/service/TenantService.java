package by.sak.dormitory.service;

import by.sak.dormitory.dto.TenantCreateUpdateDto;
import by.sak.dormitory.dto.TenantReadDto;

import java.util.List;
import java.util.Optional;

public interface TenantService {

    List<TenantReadDto> findAll();

    Optional<TenantReadDto> findById(Integer tenantId);

    TenantReadDto create(TenantCreateUpdateDto tenantCreateUpdateDto);

    Optional<TenantReadDto> update(Integer id, TenantCreateUpdateDto tenantCreateUpdateDto);

    boolean delete(Integer id);
}
