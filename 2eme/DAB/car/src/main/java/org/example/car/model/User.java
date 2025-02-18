package org.example.car.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "user", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "firstname")
    private String firstname;
}
