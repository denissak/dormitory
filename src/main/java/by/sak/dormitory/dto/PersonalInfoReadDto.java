package by.sak.dormitory.dto;

import by.sak.dormitory.entity.Sex;
import by.sak.dormitory.entity.StatusCitizen;
import lombok.Value;

import java.time.LocalDate;

@Value
public class PersonalInfoReadDto {
    Integer id;
    String firstName;
    String lastName;
    String patronymic;
    String phoneNumber;
    String image;
    Sex sex;
    LocalDate birthdate;
    String passportNumber;
    String idPassportNumber;
    String passportIssuedBy;
    String registration;
    StatusCitizen status;
    String pets;
    Integer bike;
    Integer stroller;
}
