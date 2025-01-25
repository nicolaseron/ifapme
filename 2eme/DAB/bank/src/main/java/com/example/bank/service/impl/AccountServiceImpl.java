package com.example.bank.service.impl;

import com.example.bank.command.CreateAccountCommand;
import com.example.bank.exception.AccountAlreadyExistException;
import com.example.bank.exception.AccountNotFoundException;
import com.example.bank.exception.BusinessException;
import com.example.bank.exception.InvalidAccountNumberException;
import com.example.bank.model.Account;
import com.example.bank.model.Person;
import com.example.bank.repository.AccountRepository;
import com.example.bank.service.AccountService;
import com.example.bank.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final PersonService personService;

    public AccountServiceImpl(AccountRepository accountRepository, PersonService personService) {
        this.accountRepository = accountRepository;
        this.personService = personService;
    }

    @Override
    public Account createAccount(CreateAccountCommand account) throws BusinessException {
        String accountNumber = account.getAccountNumber();
        if (accountNumber.length() != 12) {
            throw new InvalidAccountNumberException();
        }
        Account accountExist = accountRepository.findAccountByAccountNumber(accountNumber);
        if (accountExist != null) {
            throw new AccountAlreadyExistException();
        }
        Person person = personService.getPersonById(account.getPersonId());
        Account acc = new Account(accountNumber, person);
        return accountRepository.save(acc);
    }

    @Override
    public Account getAccountById(Integer id) throws BusinessException {
        return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException(id));
    }

    @Override
    public List<Account> getAccounts(Integer personId) throws BusinessException{
        Account account = this.getAccountById(personId);
        return accountRepository.findAccountByIdPerson_Id(account.getId());
    }
}
