package by.sak.dormitory.service;

import by.sak.dormitory.dto.DormitoryCreateUpdateDto;
import by.sak.dormitory.dto.DormitoryReadDto;
import by.sak.dormitory.dto.PersonalInfoCreateUpdateDto;
import by.sak.dormitory.dto.PersonalInfoReadDto;

import java.util.List;
import java.util.Optional;

public interface DormitoryService {

    List<DormitoryReadDto> findAll ();

    Optional<DormitoryReadDto> findById (Integer dormitoryId);

    DormitoryReadDto create (DormitoryCreateUpdateDto dormitory);

    Optional<DormitoryReadDto> update (Integer id, DormitoryCreateUpdateDto dormitory);

    boolean delete (Integer id);
}
