package com.example.bank.exception;

public class PersonNotFoundException extends BusinessException {
    public PersonNotFoundException(Integer id) {
        super("La personne avec l'id " + id + " n'existe pas");
    }
}
