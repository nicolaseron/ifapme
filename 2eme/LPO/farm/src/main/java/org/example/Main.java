package org.example;

import org.example.animals.*;
import org.example.person.Farmer;
import org.example.person.Veterinarians;

public class Main {
    public static void main(String[] args) {
        Chicken chicken = new Chicken("Poulet", 2);
        Cow cow = new Cow("vache", 4);
        Pig pig = new Pig("cochon", 4);
        Farmer farmer = new Farmer("John");
        Veterinarians veterinarians = new Veterinarians("Jacques");

        pig.cry();
        cow.cry();
        chicken.cry();

        farmer.feed(pig);
        farmer.feed(cow);
        veterinarians.health(chicken);
        veterinarians.health(pig);

        Egg egg = chicken.product();
        Chorizo chorizo = pig.product();
    }
}