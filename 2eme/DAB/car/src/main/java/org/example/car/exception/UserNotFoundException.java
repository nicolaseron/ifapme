package org.example.car.exception;

public class UserNotFoundException extends BusinessException {

    public UserNotFoundException(Integer userId) {
        super("L'utilisateur avec l'id " + userId + " n'existe pas !");
    }
}
