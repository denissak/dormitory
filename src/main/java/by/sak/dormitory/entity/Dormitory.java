package by.sak.dormitory.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString(exclude = "rooms")
@EqualsAndHashCode(exclude = "rooms")
@Table(name = "dormitory")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dormitory implements BaseEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private Double square;
    private Double squareLive;
    private LocalDate startYear;
    private Integer amountRooms;
    @OneToMany(mappedBy = "dormitory", fetch = FetchType.LAZY)
    private List<Room> rooms = new ArrayList<>();
}
