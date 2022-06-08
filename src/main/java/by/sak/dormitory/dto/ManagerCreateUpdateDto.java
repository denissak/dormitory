package by.sak.dormitory.dto;

import lombok.*;

import java.time.LocalDate;

@Value
public class ManagerCreateUpdateDto {
    String name;
    String typeDocument;
    String number;
    LocalDate date;
}
