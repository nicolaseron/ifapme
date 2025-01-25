package com.example.bank.service.impl;

import com.example.bank.command.CreateTransactionBaseCommand;
import com.example.bank.command.CreateTransactionTransfertCommand;
import com.example.bank.exception.AccountLimitOverdraftException;
import com.example.bank.exception.BusinessException;
import com.example.bank.exception.SameAccountTransfertExecption;
import com.example.bank.model.Account;
import com.example.bank.model.Transaction;
import com.example.bank.model.TransactionType;
import com.example.bank.repository.AccountRepository;
import com.example.bank.repository.TransactionRepository;
import com.example.bank.service.AccountService;
import com.example.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;
    @Value("${account.overdrawn.limit}")
    private Integer accountOverdrawnLimit;

    private final TransactionRepository transactionRepository;
    private final AccountService accountService;

    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountService accountService, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
        this.accountRepository = accountRepository;
    }

    @Override
    public Transaction deposit(CreateTransactionBaseCommand transaction) throws BusinessException {
        Account account = accountService.getAccountById(transaction.getAccountId());
        account.setBalance(account.getBalance() + transaction.getAmount());
        accountRepository.save(account);
        Transaction currentTransaction = new Transaction(TransactionType.DEPOT, transaction.getAmount(), account, null);
        return transactionRepository.save(currentTransaction);
    }

    @Override
    public Transaction retrait(CreateTransactionBaseCommand transaction) throws BusinessException {
        Account account = accountService.getAccountById(transaction.getAccountId());

        if (account.getBalance() - transaction.getAmount() < accountOverdrawnLimit) {
            throw new AccountLimitOverdraftException(accountOverdrawnLimit);
        }
        account.setBalance(account.getBalance() - transaction.getAmount());
        accountRepository.save(account);
        Transaction currentTransaction = new Transaction(TransactionType.RETRAIT, transaction.getAmount(), account, null);
        return transactionRepository.save(currentTransaction);
    }

    @Override
    public Transaction transfert(CreateTransactionTransfertCommand transaction) throws BusinessException {
        Account account = accountService.getAccountById(transaction.getAccountId());
        if (account.getBalance() - transaction.getAmount() < accountOverdrawnLimit) {
            throw new AccountLimitOverdraftException(accountOverdrawnLimit);
        }
        if (transaction.getAccountId().equals(transaction.getBeneficiaryId())){
            throw new SameAccountTransfertExecption();
        }
        Account beneficiaryAccount = accountService.getAccountById(transaction.getBeneficiaryId());
        account.setBalance(account.getBalance() - transaction.getAmount());
        beneficiaryAccount.setBalance(beneficiaryAccount.getBalance() + transaction.getAmount());
        accountRepository.save(account);
        accountRepository.save(beneficiaryAccount);
        Transaction currentTransaction = new Transaction(TransactionType.TRANSFERT, transaction.getAmount(), account, beneficiaryAccount);
        return transactionRepository.save(currentTransaction);
    }

    @Override
    public List<Transaction> getTransactionsHistory(Integer compteId) throws BusinessException {
        Account account = accountService.getAccountById(compteId);
        return transactionRepository.findAllByIdAccount_Id(account.getId());
    }
}
