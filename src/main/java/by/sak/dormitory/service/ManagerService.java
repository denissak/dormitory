package by.sak.dormitory.service;

import by.sak.dormitory.dto.ManagerCreateUpdateDto;
import by.sak.dormitory.dto.ManagerReadDto;
import java.util.Optional;

public interface ManagerService {

    Optional<ManagerReadDto> findById (Integer managerId);

    Optional<ManagerReadDto> update (Integer id, ManagerCreateUpdateDto managerDto);

}
