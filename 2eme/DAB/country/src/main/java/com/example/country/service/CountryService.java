package com.example.country.service;

import com.example.country.Command.CountryComamnd;
import com.example.country.Exception.BusinessException;
import com.example.country.model.Country;
import com.example.country.model.CountryAPI;

public interface CountryService {
    Country searchCountry(CountryComamnd command) throws BusinessException;
    Country countryBuilder(CountryAPI countryAPI);
}