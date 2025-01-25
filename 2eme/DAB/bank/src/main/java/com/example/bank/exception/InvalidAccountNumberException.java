package com.example.bank.exception;

public class InvalidAccountNumberException extends BusinessException {
    public InvalidAccountNumberException() {
        super("Le compte doit contenir 12 caractères !");
    }
}
