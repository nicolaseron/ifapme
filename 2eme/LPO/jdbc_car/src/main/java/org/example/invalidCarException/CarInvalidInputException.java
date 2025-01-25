package org.example.invalidCarException;

import jdk.jshell.JShell;

public class CarInvalidInputException extends BusinessException {
    public CarInvalidInputException() {
        super("Un champ est vide ou incorrect");
    }
}
