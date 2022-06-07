package by.sak.dormitory.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString(exclude = {"workPlaces", "contracts"})
@EqualsAndHashCode(exclude = {"workPlaces", "contracts"})
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements BaseEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String password;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_info_id")
    private PersonalInfo personalInfo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Contract> contracts = new ArrayList<>();
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<WorkPlace> workPlaces = new ArrayList<>();
    private String jobTitle;
    private String notes;
    private Boolean isTenant;
    private LocalDate dateRegistration;
    private LocalDate dateRegistrationEnd;
    private LocalDate dateRevise;
    @Enumerated(EnumType.STRING)
    private StatusEmployee statusEmployee;
}
