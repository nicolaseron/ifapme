package com.example.bank.exception;

public class SameAccountTransfertExecption extends BusinessException{
    public SameAccountTransfertExecption () {
        super("Pourquoi essaye tu de transfer de l'argent sur le même compte ? ");
    }
}
