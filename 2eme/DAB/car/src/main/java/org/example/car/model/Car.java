package org.example.car.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car", schema = "public")
public class Car {
    @Id
    @Column(name = "plaque_number")
    private String plaqueNumber;

    @Enumerated(EnumType.STRING)
    private Color color;

    private Integer kilometres = 0;

    private Integer kilometreEntretien = 0;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "modele_id")
    private Model model;

    public Car(String plaqueNumber, Color color, User userId , Model model) {
        this.plaqueNumber = plaqueNumber;
        this.color = color;
        this.user = userId;
        this.model = model;
    }
}