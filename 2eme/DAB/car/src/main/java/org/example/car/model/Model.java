package org.example.car.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "model")
public class Model {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "marque_id", nullable = false)
    private Marque marque;

    public Model(Integer id, String name, Marque marque) {
        this.id = id;
        this.name = name;
        this.marque = marque;
    }
}