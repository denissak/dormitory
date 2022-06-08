package by.sak.dormitory.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "personal_info")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonalInfo implements BaseEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    private String patronymic;
    private String phoneNumber;
    private String image;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private LocalDate birthdate;
    private String passportNumber;
    private String idPassportNumber;
    private String passportIssuedBy;
    private String registration;
    @Enumerated(EnumType.STRING)
    private StatusCitizen status;
    private String partner;
    private String children;
    private String pets;
    private Integer bike;
    private Integer stroller;
}
