package by.sak.dormitory.service;

import by.sak.dormitory.dto.PersonalInfoCreateUpdateDto;
import by.sak.dormitory.dto.PersonalInfoReadDto;

import java.util.List;
import java.util.Optional;

public interface PersonalInfoService {

    List<PersonalInfoReadDto> findAll ();

    Optional<PersonalInfoReadDto> findById (Integer personalInfoId);

    PersonalInfoReadDto create (PersonalInfoCreateUpdateDto personalDto);

    Optional<PersonalInfoReadDto> update (Integer id, PersonalInfoCreateUpdateDto personalInfoCreateUpdateDto);

    boolean delete (Integer id);
}
