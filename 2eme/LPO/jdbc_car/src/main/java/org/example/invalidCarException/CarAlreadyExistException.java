package org.example.invalidCarException;

public class CarAlreadyExistException extends BusinessException {
    public CarAlreadyExistException(int id) {
        super("Une voiture existe déjà dans la table avec l'id " + id);
    }
}
