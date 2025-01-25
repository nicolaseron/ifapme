package org.example.animals;

public class Cow extends Animals implements Production<Milk> {
    public Cow(String name, int nbrLegs) {
        super(name, nbrLegs);
    }

    @Override
    public Milk product() {
        return new Milk();
    }

    public void cry() {
        System.out.println("The cow cried !");
    }


}
