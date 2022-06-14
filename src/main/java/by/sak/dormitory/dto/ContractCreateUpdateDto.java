package by.sak.dormitory.dto;

import by.sak.dormitory.entity.TypeContract;
import lombok.Value;

import java.time.LocalDate;

@Value
public class ContractCreateUpdateDto {
    String contractNumber;
    LocalDate contractStart;
    LocalDate contractEnd;
    TypeContract type;
    LocalDate contractRegistration;
    String numberRegistration;
    LocalDate contractPetition;
    Integer tenantId;
}
