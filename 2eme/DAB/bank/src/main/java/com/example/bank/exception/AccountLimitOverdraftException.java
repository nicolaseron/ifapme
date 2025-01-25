package com.example.bank.exception;

public class AccountLimitOverdraftException extends BusinessException {

    public AccountLimitOverdraftException(Integer accountOverdrawnLimit) {
        super("Vous ne pouvez pas dépasser la limite de découvert de " + accountOverdrawnLimit + " sur votre compte !");
    }

}
