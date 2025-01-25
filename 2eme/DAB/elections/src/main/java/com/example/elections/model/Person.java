package com.example.elections.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person {
    @Id
    @ColumnDefault("nextval('person_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname", nullable = false, length = Integer.MAX_VALUE)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = Integer.MAX_VALUE)
    private String lastname;

    @Column(name = "national_number", nullable = false, length = Integer.MAX_VALUE)
    private String nationalNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Adress address;

}