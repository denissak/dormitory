package by.sak.dormitory.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "relation")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Relation implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_tenant_id")
    private Tenant currentTenant;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_tenant_id")
    private Tenant familyTenant;
    @Enumerated(EnumType.STRING)
    private StatusFamily statusFamily;
}
