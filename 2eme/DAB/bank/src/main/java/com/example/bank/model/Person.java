package com.example.bank.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('person_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname", nullable = false, length = Integer.MAX_VALUE)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = Integer.MAX_VALUE)
    private String lastname;

    @Column(name = "email", nullable = false, length = Integer.MAX_VALUE)
    private String email;

}