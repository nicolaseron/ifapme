package org.example.animals;

public class Pig extends Animals implements Production<Chorizo> {
    public Pig(String name, int nbrLegs) {
        super(name, nbrLegs);
    }

    @Override
    public Chorizo product() {
        return new Chorizo();
    }

    public void cry() {
        System.out.println("The pig cried !");
    }
}
