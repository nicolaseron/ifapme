package com.example.bank.controller;

import com.example.bank.command.CreateAccountCommand;
import com.example.bank.exception.BusinessException;
import com.example.bank.model.Account;
import com.example.bank.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account createAccount(@RequestBody CreateAccountCommand account) throws BusinessException {
        return accountService.createAccount(account);
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Integer id) throws BusinessException {
        return accountService.getAccountById(id);
    }

    @GetMapping("person/{personId}")
    public List<Account> getAccounts(@PathVariable Integer personId) {
        return accountService.getAccounts(personId);
    }
}
