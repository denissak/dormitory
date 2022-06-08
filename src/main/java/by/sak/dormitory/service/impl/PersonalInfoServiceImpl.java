package by.sak.dormitory.service.impl;

import by.sak.dormitory.dto.PersonalInfoCreateUpdateDto;
import by.sak.dormitory.dto.PersonalInfoReadDto;
import by.sak.dormitory.mapper.PersonalInfoReadMapper;
import by.sak.dormitory.mapper.PersonalInfoCreateUpdateMapper;
import by.sak.dormitory.repository.PersonalInfoRepository;
import by.sak.dormitory.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {

    private final PersonalInfoRepository personalInfoRepository;
    private final PersonalInfoReadMapper personalInfoReadMapper;
    private final PersonalInfoCreateUpdateMapper personalInfoCreateUpdateMapper;

    @Autowired
    public PersonalInfoServiceImpl(PersonalInfoRepository personalInfoRepository, PersonalInfoReadMapper personalInfoReadMapper, PersonalInfoCreateUpdateMapper personalInfoCreateUpdateMapper) {
        this.personalInfoRepository = personalInfoRepository;
        this.personalInfoReadMapper = personalInfoReadMapper;
        this.personalInfoCreateUpdateMapper = personalInfoCreateUpdateMapper;
    }

    @Override
    public List<PersonalInfoReadDto> findAll() {
        return personalInfoRepository.findAll().stream().map(personalInfoReadMapper::convertToPersonalInfoReadDto).toList();
    }

    @Override
    public Optional<PersonalInfoReadDto> findById(Integer personalInfoId) {
        return personalInfoRepository.findById(personalInfoId).map(personalInfoReadMapper::convertToPersonalInfoReadDto);
    }

    @Transactional
    @Override
    public Optional<PersonalInfoReadDto> update(Integer id, PersonalInfoCreateUpdateDto personalInfoCreateUpdateDto) {
        return personalInfoRepository.findById(id).map(personalInfo -> personalInfoCreateUpdateMapper.map(personalInfoCreateUpdateDto, personalInfo))
                .map(personalInfoRepository::saveAndFlush)
                .map(personalInfoReadMapper::convertToPersonalInfoReadDto);
    }

    @Transactional
    @Override
    public PersonalInfoReadDto create(PersonalInfoCreateUpdateDto personalDto) {
        return Optional.of(personalDto)
                .map(personalInfoCreateUpdateMapper::map)
                .map(personalInfoRepository::save)
                .map(personalInfoReadMapper::convertToPersonalInfoReadDto)
                .orElseThrow();
    }

    @Transactional
    @Override
    public boolean delete(Integer id) {
        return personalInfoRepository.findById(id).map(personalInfo -> {
                    personalInfoRepository.delete(personalInfo);
                    personalInfoRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
