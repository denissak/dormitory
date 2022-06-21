package by.sak.dormitory.repository;

import by.sak.dormitory.entity.PersonalInfo;
import by.sak.dormitory.entity.Relation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationRepository extends JpaRepository<Relation, Integer> {
}
