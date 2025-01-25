package com.example.elections.service.impl;

import com.example.elections.command.CreateAdressCommand;
import com.example.elections.dto.AdressDto;
import com.example.elections.model.Adress;
import com.example.elections.repository.AdressRepository;
import com.example.elections.service.AdressService;
import com.example.elections.utils.ModelMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AdressServiceImpl implements AdressService {
    private final AdressRepository adressRepository;

    public AdressServiceImpl(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    @Override
    public AdressDto createAdress(CreateAdressCommand command) {
        Adress adress = Adress.builder()
                .box(command.getBox())
                .street(command.getStreet())
                .postalCode(command.getPostalCode())
                .localite(command.getLocalite()).build();
        Adress createdAdress = adressRepository.save(adress);
        return ModelMapperUtils.getInstance().map(createdAdress, AdressDto.class);
    };
}
