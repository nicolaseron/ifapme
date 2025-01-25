package org.example.car.exception;

public class UserAlreadyExistException extends BusinessException{

    public UserAlreadyExistException() {
        super("L'utilisateur existe déjà");
    }
}
