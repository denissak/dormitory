package by.sak.dormitory.mapper;

import by.sak.dormitory.dto.PersonalInfoCreateUpdateDto;
import by.sak.dormitory.entity.PersonalInfo;
import org.springframework.stereotype.Component;

@Component
public class PersonalInfoCreateUpdateMapper implements Mapper<PersonalInfoCreateUpdateDto, PersonalInfo>{

    @Override
    public PersonalInfo map(PersonalInfoCreateUpdateDto object) {
        PersonalInfo personalInfo = new PersonalInfo();
        copy(object, personalInfo);

        return personalInfo;
    }

    @Override
    public PersonalInfo map(PersonalInfoCreateUpdateDto fromObject, PersonalInfo toObject) {
        copy(fromObject, toObject);

        return toObject;
    }

    private void copy (PersonalInfoCreateUpdateDto object, PersonalInfo personalInfo) {
        personalInfo.setFirstName(object.getFirstName());
        personalInfo.setLastName(object.getLastName());
        personalInfo.setPatronymic(object.getPatronymic());
        personalInfo.setPhoneNumber(object.getPhoneNumber());
        personalInfo.setImage(object.getImage());
        personalInfo.setSex(object.getSex());
        personalInfo.setBirthdate(object.getBirthdate());
        personalInfo.setPassportNumber(object.getPassportNumber());
        personalInfo.setIdPassportNumber(object.getIdPassportNumber());
        personalInfo.setPassportIssuedBy(object.getPassportIssuedBy());
        personalInfo.setRegistration(object.getRegistration());
        personalInfo.setStatus(object.getStatus());
//        personalInfo.setPartner(object.getPartner());
//        personalInfo.setChildren(object.getChildren());
        personalInfo.setPets(object.getPets());
        personalInfo.setBike(object.getBike());
        personalInfo.setStroller(object.getStroller());
    }
}
