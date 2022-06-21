package by.sak.dormitory.dto;

import by.sak.dormitory.entity.StatusFamily;
import lombok.ToString;
import lombok.Value;

@Value
@ToString(exclude = {"currentTenantReadDto", "familyTenantReadDto"})
public class RelationReadDto {
    Integer id;
    TenantReadDto currentTenantReadDto;
    TenantReadDto familyTenantReadDto;
    StatusFamily statusFamily;
}
