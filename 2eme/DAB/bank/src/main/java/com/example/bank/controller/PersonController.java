package com.example.bank.controller;

import com.example.bank.exception.BusinessException;
import com.example.bank.model.Person;
import com.example.bank.service.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) throws BusinessException {
        return personService.createPerson(person);
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Integer id) throws BusinessException {
        return personService.getPersonById(id);
    }
}
