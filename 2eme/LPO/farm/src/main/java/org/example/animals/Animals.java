package org.example.animals;

import lombok.Data;

@Data
public abstract class Animals {
    private String name;
    private int nbrLegs;

    Animals(String name, int nbrLegs) {
        this.name = name;
        this.nbrLegs = nbrLegs;
    }
}
