package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.ManagerCreateUpdateDto;
import by.sak.dormitory.entity.Manager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class ManagerUpdateMapper implements Mapper<ManagerCreateUpdateDto, Manager>{

    @Override
    public Manager map(ManagerCreateUpdateDto fromObject, Manager toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    @Override
    public Manager map(ManagerCreateUpdateDto object) {
        Manager manager = new Manager();
        copy(object, manager);

        return manager;
    }

    private void copy (ManagerCreateUpdateDto object, Manager manager) {
        manager.setName(object.getName());
        manager.setTypeDocument(object.getTypeDocument());
        manager.setNumber(object.getNumber());
        manager.setDate(object.getDate());
    }
}
