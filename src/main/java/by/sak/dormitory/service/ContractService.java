package by.sak.dormitory.service;

import by.sak.dormitory.dto.ContractCreateUpdateDto;
import by.sak.dormitory.dto.ContractReadDto;

import java.util.List;
import java.util.Optional;

public interface ContractService {

    List<ContractReadDto> findAll();

    Optional<ContractReadDto> findById(Integer contractId);

    ContractReadDto create(ContractCreateUpdateDto contractCreateUpdateDto);

    Optional<ContractReadDto> update(Integer id, ContractCreateUpdateDto contractCreateUpdateDto);

    boolean delete(Integer id);

}
