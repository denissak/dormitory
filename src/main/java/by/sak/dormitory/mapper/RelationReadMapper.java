package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.RelationReadDto;
import by.sak.dormitory.entity.Relation;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = TenantReadMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RelationReadMapper {
    RelationReadMapper INSTANCE = Mappers.getMapper(RelationReadMapper.class);

    @Mapping(source = "currentTenant", target = "currentTenantReadDto")
    @Mapping(source = "familyTenant", target = "familyTenantReadDto")
    RelationReadDto convertToRelationReadDto(Relation relation);

    @Mapping(source = "currentTenantReadDto", target = "currentTenant")
    @Mapping(source = "familyTenantReadDto", target = "familyTenant")
    Relation convertToRelation(RelationReadDto relationReadDto);
}
