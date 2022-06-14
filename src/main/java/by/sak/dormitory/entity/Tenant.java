package by.sak.dormitory.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
//@ToString(exclude = "contracts")
//@EqualsAndHashCode(exclude = "contracts")
@Table(name = "tenant")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tenant implements BaseEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_info_id")
    private PersonalInfo personalInfo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workplace_id")
    private WorkPlace workPlace;
    private String jobTitle;
    private String notes;
    private Boolean isTenant;
    private LocalDate dateRegistration;
    private LocalDate dateRegistrationEnd;
    private LocalDate dateRevise;
    @Enumerated(EnumType.STRING)
    private StatusEmployee statusEmployee;
}
