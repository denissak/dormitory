package by.sak.dormitory.repository;

import by.sak.dormitory.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ManagerRepository extends JpaRepository<Manager, Integer> {

//    @Query("select m from Manager m " +
//            "where m.id = :managerId")
//    Optional<Manager> findById(@Param("managerId") Integer managerId);

//    Optional<Manager> findById(Integer managerId);
//
//    List<Manager> findAll();
}
