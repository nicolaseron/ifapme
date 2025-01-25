package org.example.invalidCarException;

public class CarColorException extends BusinessException {

    public CarColorException() {
        super("La voiture ne peut pas être rose !!!");
    }

}
