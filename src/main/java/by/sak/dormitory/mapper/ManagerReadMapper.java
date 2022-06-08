package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.ManagerReadDto;
import by.sak.dormitory.entity.Manager;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ManagerReadMapper {

    ManagerReadMapper INSTANCE = Mappers.getMapper(ManagerReadMapper.class);

    Manager convertToManager(ManagerReadDto managerReadDto);

    ManagerReadDto convertToManagerReadDto(Manager manager);
}
