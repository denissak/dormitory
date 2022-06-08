package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.DormitoryCreateUpdateDto;
import by.sak.dormitory.entity.Dormitory;
import org.springframework.stereotype.Component;

@Component
public class DormitoryCreateUpdateMapper implements Mapper<DormitoryCreateUpdateDto, Dormitory>{

    @Override
    public Dormitory map(DormitoryCreateUpdateDto object) {
        Dormitory dormitory = new Dormitory();
        copy(object, dormitory);

        return dormitory;
    }

    @Override
    public Dormitory map(DormitoryCreateUpdateDto fromObject, Dormitory toObject) {
        copy(fromObject, toObject);

        return toObject;
    }

    private void copy (DormitoryCreateUpdateDto object, Dormitory dormitory) {
        dormitory.setName(object.getName());
        dormitory.setAddress(object.getAddress());
        dormitory.setSquare(object.getSquare());
        dormitory.setSquareLive(object.getSquareLive());
        dormitory.setStartYear(object.getStartYear());
        dormitory.setAmountRooms(object.getAmountRooms());
    }
}
