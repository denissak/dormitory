package by.sak.dormitory.dto;

import lombok.ToString;
import lombok.Value;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Value
//@ToString(exclude = "roomReadDtoList")
public class DormitoryReadDto {
     Integer id;
     String name;
     String address;
     Double square;
     Double squareLive;
     LocalDate startYear;
     Integer amountRooms;
//     List<RoomReadDto> roomReadDtoList = new ArrayList<>();
}
