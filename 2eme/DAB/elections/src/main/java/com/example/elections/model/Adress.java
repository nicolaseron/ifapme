package com.example.elections.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "adress")
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('adress_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "localite", nullable = false, length = Integer.MAX_VALUE)
    private String localite;

    @Column(name = "postal_code", nullable = false, length = Integer.MAX_VALUE)
    private Integer postalCode;

    @Column(name = "street", nullable = false, length = Integer.MAX_VALUE)
    private String street;

    @Column(name = "box", nullable = false, length = Integer.MAX_VALUE)
    private String box;

}