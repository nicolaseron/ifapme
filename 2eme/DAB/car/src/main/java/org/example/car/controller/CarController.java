package org.example.car.controller;

import org.example.car.command.CarEntretienCommand;
import org.example.car.command.CarRouleCommand;
import org.example.car.command.CreateCarCommand;
import org.example.car.exception.BusinessException;
import org.example.car.model.Car;
import org.example.car.service.impl.CarServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/car")
public class CarController {

    private final CarServiceImpl carService;

    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public List<Car> getAllCars() {
        return carService.findAll();
    }

    @GetMapping("/{numberPlaque}")
    public Car getCarById(@PathVariable String numberPlaque) {
        return carService.getById(numberPlaque);
    }

    @PostMapping
    public Car addCar(@RequestBody CreateCarCommand car) throws BusinessException {
        return carService.createCar(car);
    }

    @PutMapping
    public Car roule(@RequestBody CarRouleCommand car) throws BusinessException {
        return carService.roule(car);
    }

    @PostMapping("/entretien")
    public void entretien(@RequestBody CarEntretienCommand car) throws BusinessException {
        carService.entretien(car);
    }
}
