package org.example.car.exception;

public class CarNotFoundException extends BusinessException {
    public CarNotFoundException() {
        super("La voiture n'existe pas !");
    }
}
