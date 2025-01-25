package com.example.bank.exception;

public class AccountAlreadyExistException extends BusinessException{
    public  AccountAlreadyExistException(){
        super("Le numéro de compte existe déjà");
    }
}
