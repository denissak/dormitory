package by.sak.dormitory.dto;

import lombok.Value;
import java.time.LocalDate;

@Value
public class DormitoryReadDto {
     Integer id;
     String name;
     String address;
     Double square;
     Double squareLive;
     LocalDate startYear;
     Integer amountRooms;
}
