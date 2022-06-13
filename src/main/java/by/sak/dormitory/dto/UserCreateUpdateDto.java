package by.sak.dormitory.dto;

import by.sak.dormitory.entity.StatusEmployee;

import lombok.Value;

import java.time.LocalDate;

@Value
public class UserCreateUpdateDto {
    String login;
    String password;
    Integer personalInfoId;
    Integer roomId;
    Integer workId;
    String jobTitle;
    String notes;
    Boolean isTenant;
    LocalDate dateRegistration;
    LocalDate dateRegistrationEnd;
    LocalDate dateRevise;
    StatusEmployee statusEmployee;
}
