package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.RoomReadDto;
import by.sak.dormitory.entity.Room;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = DormitoryReadMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RoomReadMapper {

    RoomReadMapper INSTANCE = Mappers.getMapper(RoomReadMapper.class);

//    @Mapping(source = "dormitory", target = "dormitoryReadDto")
    RoomReadDto convertToRoomReadDto(Room room);

//    @Mapping(source = "dormitoryReadDto", target = "dormitory")
    Room convertToRoom(RoomReadDto roomReadDto);
}
