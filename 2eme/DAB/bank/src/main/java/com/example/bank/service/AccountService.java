package com.example.bank.service;

import com.example.bank.command.CreateAccountCommand;
import com.example.bank.exception.AccountNotFoundException;
import com.example.bank.exception.BusinessException;
import com.example.bank.model.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(CreateAccountCommand account) throws BusinessException;

    Account getAccountById(Integer id) throws BusinessException;

    List<Account> getAccounts(Integer personId) throws BusinessException;
}
