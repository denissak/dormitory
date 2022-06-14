package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.UserReadDto;
import by.sak.dormitory.entity.Users;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserReadMapper {

    ContractReadMapper INSTANCE = Mappers.getMapper(ContractReadMapper.class);

    UserReadDto convertToUserReadDto(Users user);

    Users convertToUser(UserReadDto userReadDto);
}
