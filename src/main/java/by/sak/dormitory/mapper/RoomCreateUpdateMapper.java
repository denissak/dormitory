package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.RoomCreateUpdateDto;
import by.sak.dormitory.entity.Dormitory;
import by.sak.dormitory.entity.Room;
import by.sak.dormitory.repository.DormitoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoomCreateUpdateMapper implements Mapper<RoomCreateUpdateDto, Room>{

    private final DormitoryRepository dormitoryRepository;

    @Autowired
    public RoomCreateUpdateMapper(DormitoryRepository dormitoryRepository) {
        this.dormitoryRepository = dormitoryRepository;
    }

    @Override
    public Room map(RoomCreateUpdateDto object) {
        Room room = new Room();
        copy(object, room);

        return room;
    }

    @Override
    public Room map(RoomCreateUpdateDto fromObject, Room toObject) {
        copy(fromObject, toObject);

        return toObject;
    }

    private void copy (RoomCreateUpdateDto object, Room room) {
        room.setNumber(object.getNumber());
        room.setType(object.getType());
        room.setSquare(object.getSquare());
        room.setSquareLive(object.getSquareLive());
        room.setFloor(object.getFloor());
        room.setImage(object.getImage());
        room.setAmount(object.getAmount());
        room.setDormitory(getDormitory(object.getDormitoryId()));
    }

    public Dormitory getDormitory(Integer dormitoryId) {
        return Optional.ofNullable(dormitoryId)
                .flatMap(dormitoryRepository::findById)
                .orElse(null);
    }

}
