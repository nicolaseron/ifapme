package com.example.country.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('country_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "internal_name", nullable = false, length = Integer.MAX_VALUE)
    private String internalName;

    @Column(name = "spoken_language", nullable = false, length = Integer.MAX_VALUE)
    private String spokenLanguage;

    @Column(name = "currency", nullable = false, length = Integer.MAX_VALUE)
    private String currency;

    @Column(name = "captial", nullable = false, length = Integer.MAX_VALUE)
    private String captial;

    @Column(name = "code", nullable = false, length = Integer.MAX_VALUE)
    private String code;
}