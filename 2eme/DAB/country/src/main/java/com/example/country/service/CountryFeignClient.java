package com.example.country.service;

import com.example.country.model.Country;
import com.example.country.model.CountryAPI;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "countryClient", url = "https://restcountries.com/v3.1")
public interface CountryFeignClient {

    @GetMapping("/alpha/{code}")
    CountryAPI[] getCountryByCode(@PathVariable("code") String code);
}
