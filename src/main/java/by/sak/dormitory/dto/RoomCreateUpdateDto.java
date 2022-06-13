package by.sak.dormitory.dto;

import by.sak.dormitory.entity.TypeRoom;
import lombok.ToString;
import lombok.Value;

@Value
public class RoomCreateUpdateDto {
    String number;
    TypeRoom type;
    Integer square;
    Integer squareLive;
    Integer floor;
    String image;
    Integer amount;
    Integer dormitoryId;
}
