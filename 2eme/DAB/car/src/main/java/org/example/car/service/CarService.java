package org.example.car.service;

import org.example.car.command.CarEntretienCommand;
import org.example.car.command.CarRouleCommand;
import org.example.car.command.CreateCarCommand;
import org.example.car.exception.BusinessException;
import org.example.car.model.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();

    Car getById(String numberPlaque);

    Car createCar(CreateCarCommand car) throws BusinessException;

    Car roule(CarRouleCommand car) throws BusinessException;

    void entretien(CarEntretienCommand car) throws BusinessException;
}
