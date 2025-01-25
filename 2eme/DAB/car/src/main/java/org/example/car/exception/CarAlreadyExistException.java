package org.example.car.exception;

public class CarAlreadyExistException extends BusinessException{
    public CarAlreadyExistException(){
        super("Car already exist");
    }
}