package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.PersonalInfoReadDto;
import by.sak.dormitory.entity.PersonalInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PersonalInfoReadMapper {

    PersonalInfoReadMapper INSTANCE = Mappers.getMapper(PersonalInfoReadMapper.class);

    PersonalInfo convertToPersonalInfo(PersonalInfoReadDto personalInfoReadDto);

    PersonalInfoReadDto convertToPersonalInfoReadDto(PersonalInfo personalInfo);
}
