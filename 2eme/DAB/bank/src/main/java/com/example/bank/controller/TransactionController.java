package com.example.bank.controller;

import com.example.bank.command.CreateTransactionBaseCommand;
import com.example.bank.command.CreateTransactionTransfertCommand;
import com.example.bank.exception.BusinessException;
import com.example.bank.model.Transaction;
import com.example.bank.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/depot")
    public Transaction deposit(@RequestBody CreateTransactionBaseCommand transaction) throws BusinessException {
        return transactionService.deposit(transaction);
    }

    @PostMapping("/retrait")
    public Transaction retreat(@RequestBody CreateTransactionBaseCommand transaction) throws BusinessException {
        return transactionService.retrait(transaction);
    }

    @PostMapping("/transfert")
    public Transaction transfer(@RequestBody CreateTransactionTransfertCommand transaction) throws BusinessException {
        return transactionService.transfert(transaction);
    }
    @GetMapping("compte/{compteId}")
    public List<Transaction> getTransactionsHistory(@PathVariable Integer compteId) throws BusinessException {
        return transactionService.getTransactionsHistory(compteId);
    }
}
