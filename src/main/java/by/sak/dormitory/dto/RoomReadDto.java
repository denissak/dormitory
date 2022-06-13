package by.sak.dormitory.dto;

import by.sak.dormitory.entity.TypeRoom;
import lombok.ToString;
import lombok.Value;

@Value
@ToString(exclude =  "dormitoryReadDto")
public class RoomReadDto {
    Integer id;
    String number;
    TypeRoom type;
    Integer square;
    Integer squareLive;
    Integer floor;
    String image;
    Integer amount;
    DormitoryReadDto dormitoryReadDto;
}
