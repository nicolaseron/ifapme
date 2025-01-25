package com.example.elections.service;

import com.example.elections.command.CreateAdressCommand;
import com.example.elections.dto.AdressDto;
import com.example.elections.model.Adress;

public interface AdressService {
    AdressDto createAdress(CreateAdressCommand adress);
}
