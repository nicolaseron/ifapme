package org.example.service.impl;

import org.example.model.Car;
import org.example.repository.CarRepository;

import java.sql.SQLException;

public class CarServiceImpl {
    CarRepository carRepository = new CarRepository();

    public CarServiceImpl() throws SQLException {
    }

    public void insertCars(Car[] cars) throws SQLException {
        carRepository.insertCars(cars);
    }

    public Car findById(String plate) {
        return carRepository.findById(plate);
    }

    public void findAllCars() {
        carRepository.findAllCars();
    }

    public void deleteCarById(String plate) {
        carRepository.deleteCarById(plate);
    }

    public Car updateCar(Car car) {
        return carRepository.updateCar(car);
    }
}
