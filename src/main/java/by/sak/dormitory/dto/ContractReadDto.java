package by.sak.dormitory.dto;

import by.sak.dormitory.entity.TypeContract;
import lombok.ToString;
import lombok.Value;

import java.time.LocalDate;

@Value
@ToString(exclude =  "userReadDto")
public class ContractReadDto {
    Integer id;
    String contractNumber;
    LocalDate contractStart;
    LocalDate contractEnd;
    TypeContract type;
    LocalDate contractRegistration;
    String numberRegistration;
    LocalDate contractPetition;
    UserReadDto userReadDto;
}
