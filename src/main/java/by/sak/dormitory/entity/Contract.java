package by.sak.dormitory.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "contract")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contract implements BaseEntity<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String contractNumber;
    private LocalDate contractStart;
    private LocalDate contractEnd;
    @Enumerated(EnumType.STRING)
    private TypeContract type;
    private LocalDate contractRegistration;
    private String numberRegistration;
    private LocalDate contractPetition;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;
}
