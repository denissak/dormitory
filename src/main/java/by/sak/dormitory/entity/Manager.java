package by.sak.dormitory.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "manager")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Manager implements BaseEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String typeDocument;
    private String number;
    private LocalDate date;
}
