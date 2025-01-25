package com.example.country.Exception;

public class CountryNotFoundException extends BusinessException {
    public CountryNotFoundException(String code) {
        super("Le pays avec le code " + code + " n'existe pas !");
    }
}
