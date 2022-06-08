//package by.sak.dormitory.mapper;
//
//import by.sak.dormitory.dto.DormitoryReadDto;
//import by.sak.dormitory.entity.Dormitory;
//import org.mapstruct.InjectionStrategy;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//import org.springframework.stereotype.Component;
//
//@Component
//@Mapper(componentModel = "spring", uses = RoomReadMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
//public interface DormitoryReadMapper {
//
//    DormitoryReadMapper INSTANCE = Mappers.getMapper(DormitoryReadMapper.class);
//
//    @Mapping(source = "rooms", target = "roomReadDtoList")
//    DormitoryReadDto convertToDormitoryReadDto(Dormitory dormitory);
//
//    @Mapping(source = "roomReadDtoList", target = "rooms")
//    Dormitory convertToDormitory(DormitoryReadDto dormitoryReadDto);
//}
