package org.example.car.service.impl;

import org.example.car.command.CarEntretienCommand;
import org.example.car.command.CarRouleCommand;
import org.example.car.command.CreateCarCommand;
import org.example.car.exception.*;
import org.example.car.model.Car;
import org.example.car.model.Model;
import org.example.car.model.User;
import org.example.car.repository.CarRepository;
import org.example.car.repository.ModelRepository;
import org.example.car.service.CarService;
import org.example.car.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Value("${car.limit.entretien}")
    private int limitEntretien;

    private final CarRepository carRepository;
    private final UserService userService;
    private final ModelRepository modelRepository;

    public CarServiceImpl(CarRepository carRepository, UserService userService, ModelRepository modelRepository) {
        this.carRepository = carRepository;
        this.userService = userService;
        this.modelRepository = modelRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getById(String plaqueNumber) {
        return carRepository.findById(plaqueNumber).orElse(null);
    }

    @Override
    public Car createCar(CreateCarCommand car) throws BusinessException {
        User user = userService.findById(car.getUserId());
        Model model = modelRepository.findById(car.getModelId()).orElseThrow(ModelNotFoundException::new);
        if (this.getById(car.getPlaqueNumber()) != null) {
            throw new CarAlreadyExistException();
        }
        if (userService.findById(car.getUserId()) == null) {
            throw new UserNotFoundException(car.getUserId());
        }
        Car newCar = new Car(car.getPlaqueNumber(), car.getColor(), user, model);
        return carRepository.save(newCar);
    }

    @Override
    public Car roule(CarRouleCommand car) throws BusinessException {
        if (car.getKilometre() > 2500) {
            throw new TrajetTropLongException();
        }
        Car currentCar = this.getById(car.getPlaqueNumber());
        if (currentCar == null) {
            throw new CarNotFoundException();
        }
        Integer totalKilometre = currentCar.getKilometres() + car.getKilometre();
        Integer testTotalKilometre = totalKilometre - currentCar.getKilometreEntretien();
        if (testTotalKilometre > limitEntretien) {
            throw new CarMaintenanceExcetpion();
        }
        currentCar.setKilometres(totalKilometre);
        return carRepository.save(currentCar);
    }

    @Override
    public void entretien(CarEntretienCommand car) throws BusinessException {
        Car currentCar = this.getById(car.getPlaqueNumber());
        if (currentCar == null) {
            throw new CarNotFoundException();
        }
        currentCar.setKilometreEntretien(currentCar.getKilometres());
        carRepository.save(currentCar);
    }
}