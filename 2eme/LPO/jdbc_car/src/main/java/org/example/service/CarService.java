package org.example.service;

import org.example.invalidCarException.BusinessException;
import org.example.invalidCarException.CarColorException;
import org.example.model.Car;

import java.util.List;

public interface CarService {
    void insertCar(Car car) throws BusinessException;

    List<Car> findAll();

    Car findById(Integer id);

    void updateCar(Car car) throws BusinessException;

    void deleteCar(Car car) throws BusinessException;
}
