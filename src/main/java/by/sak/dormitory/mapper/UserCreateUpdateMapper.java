package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.UserCreateUpdateDto;
import by.sak.dormitory.entity.*;
import by.sak.dormitory.repository.PersonalInfoRepository;
import by.sak.dormitory.repository.RoomRepository;
import by.sak.dormitory.repository.WorkPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserCreateUpdateMapper implements Mapper<UserCreateUpdateDto, User>{

    private final PersonalInfoRepository personalInfoRepository;
    private final RoomRepository roomRepository;
    private final WorkPlaceRepository workPlaceRepository;

    @Autowired
    public UserCreateUpdateMapper(PersonalInfoRepository personalInfoRepository, RoomRepository roomRepository, WorkPlaceRepository workPlaceRepository) {
        this.personalInfoRepository = personalInfoRepository;
        this.roomRepository = roomRepository;
        this.workPlaceRepository = workPlaceRepository;
    }

    @Override
    public User map(UserCreateUpdateDto object) {
        User user = new User();
        copy(object, user);

        return user;
    }

    @Override
    public User map(UserCreateUpdateDto fromObject, User toObject) {
        copy(fromObject, toObject);

        return toObject;
    }

    private void copy (UserCreateUpdateDto object, User user) {
        user.setLogin(object.getLogin());
        user.setPassword(object.getPassword());
        user.setPersonalInfo(getPersonalInfo(object.getPersonalInfoId()));
        user.setRoom(getRoom(object.getRoomId()));
        user.setWorkPlace(getWork(object.getWorkId()));
        user.setJobTitle(object.getJobTitle());
        user.setNotes(object.getNotes());
        user.setIsTenant(object.getIsTenant());
        user.setDateRegistration(object.getDateRegistration());
        user.setDateRegistrationEnd(object.getDateRegistrationEnd());
        user.setDateRevise(object.getDateRevise());
        user.setStatusEmployee(object.getStatusEmployee());
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
