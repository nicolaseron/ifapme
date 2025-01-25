package com.example.bank.exception;

public class EmailNotValidException extends BusinessException{
    public EmailNotValidException() {
        super("L'adresse mail n'est pas valide");
    }
}
