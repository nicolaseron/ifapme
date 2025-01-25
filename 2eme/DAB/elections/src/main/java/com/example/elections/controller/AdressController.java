package com.example.elections.controller;

import com.example.elections.command.CreateAdressCommand;
import com.example.elections.dto.AdressDto;
import com.example.elections.model.Adress;
import com.example.elections.service.impl.AdressServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adress")
public class AdressController {

    private AdressServiceImpl adressService;

    public AdressController(AdressServiceImpl adressService) {
        this.adressService = adressService;
    }

    @PostMapping
    private AdressDto createAdress(@RequestBody CreateAdressCommand adress) {
        return adressService.createAdress(adress);
    }
}
