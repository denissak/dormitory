package by.sak.dormitory.repository;

import by.sak.dormitory.entity.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Integer> {
}
