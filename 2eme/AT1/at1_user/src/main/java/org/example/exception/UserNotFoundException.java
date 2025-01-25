package org.example.exception;

public class UserNotFoundException extends BusinessException {
    public UserNotFoundException(int id) {
        super("L'utilisateur avec l'id " + id + " n'existe pas !");
    }
}
