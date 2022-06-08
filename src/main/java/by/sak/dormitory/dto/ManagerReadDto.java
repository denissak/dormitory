package by.sak.dormitory.dto;

import lombok.*;

import java.time.LocalDate;

@Value
public class ManagerReadDto {
     Integer id;
     String name;
     String typeDocument;
     String number;
     LocalDate date;
}
