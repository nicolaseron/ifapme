package com.example.country.service.impl;

import com.example.country.Command.CountryComamnd;
import com.example.country.Exception.BusinessException;
import com.example.country.Exception.CountryNotFoundException;
import com.example.country.Repository.CountryRepository;
import com.example.country.model.Country;
import com.example.country.model.CountryAPI;
import com.example.country.service.CountryFeignClient;
import com.example.country.service.CountryService;
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryFeignClient countryFeignClient;
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryFeignClient countryFeignClient, CountryRepository countryRepository) {
        this.countryFeignClient = countryFeignClient;
        this.countryRepository = countryRepository;
    }

    @Override
    public Country searchCountry(CountryComamnd command) throws BusinessException {
        String code = command.getCode().toUpperCase();
        Country country = countryRepository.findCountryByCode(code).orElse(null);
        if (country != null) {
            return country;
        }
        CountryAPI countryAPI;
        try {
            countryAPI = countryFeignClient.getCountryByCode(code)[0];
        } catch (FeignException e) {
            throw new CountryNotFoundException(code);
        }
        country = countryBuilder(countryAPI);
        return countryRepository.save(country);
    }

    public Country countryBuilder(CountryAPI countryAPI) {
        Set<String> languages = countryAPI.getName().getNativeName().keySet();
        Set<String> spokenLanguagesSet = countryAPI.getLanguages().keySet();
        Set<String> currency = countryAPI.getCurrencies().keySet();
        StringBuilder nameInAllLanguages = new StringBuilder();
        StringBuilder spokenLanguages = new StringBuilder();
        StringBuilder allCurrency = new StringBuilder();
        int i = 0;
        int j = 0;
        int k = 0;
        for (String language : languages) {
            nameInAllLanguages.append(countryAPI.getName().getNativeName().get(language).getCommon());
            i++;
            if (i != languages.size()) {
                nameInAllLanguages.append(", ");
            }
        }
        for (String language : spokenLanguagesSet) {
            spokenLanguages.append(countryAPI.getLanguages().get(language));
            k++;
            if (k != spokenLanguagesSet.size()) {
                spokenLanguages.append(", ");
            }
        }
        for (String curr : currency) {
            allCurrency.append(countryAPI.getCurrencies().get(curr).getName());
            j++;
            if (j != currency.size()) {
                allCurrency.append(", ");
            }

        }
        Country country = Country.builder()
                .name(countryAPI.getName().getCommon())
                .internalName(String.valueOf(nameInAllLanguages))
                .spokenLanguage(String.valueOf(spokenLanguages))
                .currency(String.valueOf(allCurrency))
                .captial(countryAPI.getCapital().getFirst())
                .code(countryAPI.getCca2())
                .build();
        return country;
    };
}
