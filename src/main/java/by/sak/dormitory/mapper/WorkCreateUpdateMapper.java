package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.WorkCreateUpdateDto;
import by.sak.dormitory.entity.WorkPlace;
import org.springframework.stereotype.Component;

@Component
public class WorkCreateUpdateMapper implements Mapper<WorkCreateUpdateDto, WorkPlace>{

    @Override
    public WorkPlace map(WorkCreateUpdateDto object) {
        WorkPlace workPlace = new WorkPlace();
        copy(object, workPlace);

        return workPlace;
    }

    @Override
    public WorkPlace map(WorkCreateUpdateDto fromObject, WorkPlace toObject) {
        copy(fromObject, toObject);

        return toObject;
    }

    private void copy (WorkCreateUpdateDto object, WorkPlace workPlace) {
        workPlace.setName(object.getName());
        workPlace.setAddress(object.getAddress());
    }
}
