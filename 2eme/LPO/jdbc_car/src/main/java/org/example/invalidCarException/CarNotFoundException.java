package org.example.invalidCarException;

public class CarNotFoundException extends BusinessException {

    public CarNotFoundException(Integer id) {
        super("La voiture avec l'id " + id + " n'existe pas");
    }

}
