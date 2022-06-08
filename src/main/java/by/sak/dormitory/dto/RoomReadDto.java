package by.sak.dormitory.dto;

import by.sak.dormitory.entity.TypeRoom;
import by.sak.dormitory.entity.User;
import lombok.ToString;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
@ToString(exclude = {"userReadDtos", "dormitoryReadDto"})
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
    List<UserReadDto> userReadDtos = new ArrayList<>();
}
