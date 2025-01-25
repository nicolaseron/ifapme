package org.example.person;

import lombok.Data;
import org.example.animals.Animals;

@Data
public class Veterinarians implements Employee {
    private String name;

    public Veterinarians(String name) {
        this.name = name;
    }

    @Override
    public void feed(Animals animals) {
        System.out.println(this.name + "feed" + animals.getName());
    }

    @Override
    public void health(Animals animals) {
        System.out.println(this.name + "health" + animals.getName());
    }
}
