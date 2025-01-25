package org.example.car.exception;

public class TrajetTropLongException extends BusinessException {
    public TrajetTropLongException() {
        super("Le trajet ne peut pas dépasser 2500 KM");
    }
}
