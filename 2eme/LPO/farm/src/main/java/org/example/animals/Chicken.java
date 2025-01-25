package org.example.animals;

public class Chicken extends Animals implements Production<Egg> {
    public Chicken(String name, int nbrLegs) {
        super(name, nbrLegs);
    }

    @Override
    public Egg product() {
        return new Egg();
    }

    public void cry() {
        System.out.println("The chicken cried !");
    }
}
