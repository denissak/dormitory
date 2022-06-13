package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.WorkReadDto;
import by.sak.dormitory.entity.WorkPlace;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface WorkReadMapper {
    WorkReadMapper INSTANCE = Mappers.getMapper(WorkReadMapper.class);

    WorkPlace convertToWorkPlace(WorkReadDto workReadDto);

    WorkReadDto convertToWorkPlaceReadDto(WorkPlace workPlace);
}
