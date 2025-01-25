package com.example.bank.service;

import com.example.bank.command.CreateTransactionBaseCommand;
import com.example.bank.command.CreateTransactionTransfertCommand;
import com.example.bank.exception.BusinessException;
import com.example.bank.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction deposit(CreateTransactionBaseCommand transaction) throws BusinessException;

    Transaction retrait(CreateTransactionBaseCommand transaction) throws BusinessException;

    Transaction transfert(CreateTransactionTransfertCommand transaction) throws BusinessException;

    List<Transaction> getTransactionsHistory(Integer compteId) throws BusinessException;
}
