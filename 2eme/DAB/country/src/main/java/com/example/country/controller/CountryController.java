package com.example.country.controller;

import com.example.country.Command.CountryComamnd;
import com.example.country.Exception.BusinessException;
import com.example.country.model.Country;
import com.example.country.model.CountryAPI;
import com.example.country.service.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/searchCountry")
    public Country searchCountry(@RequestBody CountryComamnd command) throws BusinessException {
        return countryService.searchCountry(command);
    }
}
