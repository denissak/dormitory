package by.sak.dormitory.dto;

import by.sak.dormitory.entity.StatusEmployee;
import lombok.ToString;
import lombok.Value;

import java.time.LocalDate;

@Value
@ToString(exclude =  {"personalInfoReadDto","roomReadDto", "workReadDto"})
public class TenantReadDto {

    Integer id;
    PersonalInfoReadDto personalInfoReadDto;
    RoomReadDto roomReadDto;
    WorkReadDto workReadDto;
    String jobTitle;
    String notes;
    Boolean isTenant;
    LocalDate dateRegistration;
    LocalDate dateRegistrationEnd;
    LocalDate dateRevise;
    StatusEmployee statusEmployee;

}
