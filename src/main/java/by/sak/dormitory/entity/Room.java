package by.sak.dormitory.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString(exclude = {"users", "dormitory"})
@EqualsAndHashCode(exclude = {"users", "dormitory"})
@Table(name = "room")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room implements BaseEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number;
    @Enumerated(EnumType.STRING)
    private TypeRoom type;
    private Integer square;
    private Integer squareLive;
    private Integer floor;
    private String image;
    private Integer amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dormitory_id")
    private Dormitory dormitory;
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();
}
