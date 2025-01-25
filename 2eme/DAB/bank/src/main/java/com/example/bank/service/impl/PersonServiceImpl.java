package com.example.bank.service.impl;

import com.example.bank.exception.BusinessException;
import com.example.bank.exception.EmailNotValidException;
import com.example.bank.exception.EmptyFieldException;
import com.example.bank.exception.PersonNotFoundException;
import com.example.bank.model.Person;
import com.example.bank.repository.PersonRepository;
import com.example.bank.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;


    public static boolean validate(String emailStr) {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }


    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public Person createPerson(Person person) throws BusinessException {
        if (!validate(person.getEmail())) {
            throw new EmailNotValidException();
        }
        if (person.getFirstname().isEmpty() || person.getLastname().isEmpty()) {
            throw new EmptyFieldException();
        }
        return personRepository.save(person);
    }

    @Override
    public Person getPersonById(Integer id) throws BusinessException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }
}
