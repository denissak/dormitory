package by.sak.dormitory.service;

import by.sak.dormitory.dto.WorkCreateUpdateDto;
import by.sak.dormitory.dto.WorkReadDto;

import java.util.List;
import java.util.Optional;

public interface WorkService {

    List<WorkReadDto> findAll ();

    Optional<WorkReadDto> findById (Integer workId);

    WorkReadDto create (WorkCreateUpdateDto workCreateUpdateDto);

    Optional<WorkReadDto> update (Integer id, WorkCreateUpdateDto workCreateUpdateDto);

    boolean delete (Integer id);

}
