package by.sak.dormitory.dto;

import by.sak.dormitory.entity.StatusFamily;
import lombok.Value;

@Value
public class RelationCreateUpdateDto {
    Integer currentTenantId;
    Integer familyTenantId;
    StatusFamily statusFamily;
}
