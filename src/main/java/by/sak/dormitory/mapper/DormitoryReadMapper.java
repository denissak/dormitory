package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.DormitoryReadDto;
import by.sak.dormitory.entity.Dormitory;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DormitoryReadMapper {

    DormitoryReadMapper INSTANCE = Mappers.getMapper(DormitoryReadMapper.class);

    DormitoryReadDto convertToDormitoryReadDto(Dormitory dormitory);

    Dormitory convertToDormitory(DormitoryReadDto dormitoryReadDto);
}
