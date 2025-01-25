package com.example.bank.exception;

public class EmptyFieldException extends BusinessException{
    public EmptyFieldException(){
        super("Certains champs sont vides !");
    }
}
