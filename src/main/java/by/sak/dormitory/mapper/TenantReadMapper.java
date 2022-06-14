package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.TenantReadDto;
import by.sak.dormitory.entity.Tenant;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = {PersonalInfoReadMapper.class, RoomReadMapper.class, WorkReadMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TenantReadMapper {

    TenantReadMapper INSTANCE = Mappers.getMapper(TenantReadMapper.class);

    @Mapping(source = "personalInfo", target = "personalInfoReadDto")
    @Mapping(source = "room", target = "roomReadDto")
    @Mapping(source = "workPlace", target = "workReadDto")
    TenantReadDto convertToTenantReadDto(Tenant tenant);

    @Mapping(source = "personalInfoReadDto", target = "personalInfo")
    @Mapping(source = "roomReadDto", target = "room")
    @Mapping(source = "workReadDto", target = "workPlace")
    Tenant convertToTenant(TenantReadDto tenantReadDto);

}
