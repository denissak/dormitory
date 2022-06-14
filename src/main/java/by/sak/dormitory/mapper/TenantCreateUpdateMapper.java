package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.TenantCreateUpdateDto;
import by.sak.dormitory.entity.*;
import by.sak.dormitory.repository.PersonalInfoRepository;
import by.sak.dormitory.repository.RoomRepository;
import by.sak.dormitory.repository.WorkPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TenantCreateUpdateMapper implements Mapper<TenantCreateUpdateDto, Tenant>{

    private final PersonalInfoRepository personalInfoRepository;
    private final RoomRepository roomRepository;
    private final WorkPlaceRepository workPlaceRepository;

    @Autowired
    public TenantCreateUpdateMapper(PersonalInfoRepository personalInfoRepository, RoomRepository roomRepository, WorkPlaceRepository workPlaceRepository) {
        this.personalInfoRepository = personalInfoRepository;
        this.roomRepository = roomRepository;
        this.workPlaceRepository = workPlaceRepository;
    }

    @Override
    public Tenant map(TenantCreateUpdateDto object) {
        Tenant tenant = new Tenant();
        copy(object, tenant);

        return tenant;
    }

    @Override
    public Tenant map(TenantCreateUpdateDto fromObject, Tenant toObject) {
        copy(fromObject, toObject);

        return toObject;
    }

    private void copy (TenantCreateUpdateDto object, Tenant tenant) {
        tenant.setPersonalInfo(getPersonalInfo(object.getPersonalInfoId()));
        tenant.setRoom(getRoom(object.getRoomId()));
        tenant.setWorkPlace(getWork(object.getWorkId()));
        tenant.setJobTitle(object.getJobTitle());
        tenant.setNotes(object.getNotes());
        tenant.setIsTenant(object.getIsTenant());
        tenant.setDateRegistration(object.getDateRegistration());
        tenant.setDateRegistrationEnd(object.getDateRegistrationEnd());
        tenant.setDateRevise(object.getDateRevise());
        tenant.setStatusEmployee(object.getStatusEmployee());
    }

    public PersonalInfo getPersonalInfo(Integer personalInfoId) {
        return Optional.ofNullable(personalInfoId)
                .flatMap(personalInfoRepository::findById)
                .orElse(null);
    }
    public Room getRoom(Integer roomId) {
        return Optional.ofNullable(roomId)
                .flatMap(roomRepository::findById)
                .orElse(null);
    }
    public WorkPlace getWork(Integer workId) {
        return Optional.ofNullable(workId)
                .flatMap(workPlaceRepository::findById)
                .orElse(null);
    }
}
