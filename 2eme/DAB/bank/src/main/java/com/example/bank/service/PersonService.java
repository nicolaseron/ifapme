package com.example.bank.service;

import com.example.bank.exception.BusinessException;
import com.example.bank.exception.EmailNotValidException;
import com.example.bank.exception.PersonNotFoundException;
import com.example.bank.model.Person;

public interface PersonService {
    Person createPerson(Person person) throws BusinessException;

    Person getPersonById(Integer id) throws BusinessException;
}
