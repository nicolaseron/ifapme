package com.example.bank.exception;

public class AccountNotFoundException extends BusinessException{
    public AccountNotFoundException(Integer id) {
        super("Le compte avec l'id " + id + " n'existe pas !");
    }
}
