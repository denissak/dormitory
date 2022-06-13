package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.ContractReadDto;
import by.sak.dormitory.dto.UserReadDto;
import by.sak.dormitory.entity.Contract;
import by.sak.dormitory.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = {PersonalInfoReadMapper.class, RoomReadMapper.class, WorkReadMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserReadMapper {

    UserReadMapper INSTANCE = Mappers.getMapper(UserReadMapper.class);

    @Mapping(source = "personalInfo", target = "personalInfoReadDto")
    @Mapping(source = "room", target = "roomReadDto")
    @Mapping(source = "workPlace", target = "workReadDto")
    UserReadDto convertToUserReadDto(User user);

    @Mapping(source = "personalInfoReadDto", target = "personalInfo")
    @Mapping(source = "roomReadDto", target = "room")
    @Mapping(source = "workReadDto", target = "workPlace")
    User convertToUser(UserReadDto userReadDto);

}
