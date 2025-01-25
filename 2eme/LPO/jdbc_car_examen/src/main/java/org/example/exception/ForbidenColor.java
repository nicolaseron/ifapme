package org.example.exception;

public class ForbidenColor extends BusinessException {

    public ForbidenColor() {
        super("La voiture ne peut pas être verte !");
    }

}
