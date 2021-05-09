package tqs.ex2;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Table(name = "Book")
@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
}
