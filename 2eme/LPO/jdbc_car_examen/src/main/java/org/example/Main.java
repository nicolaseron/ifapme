package org.example;

import org.example.model.Car;
import org.example.service.impl.CarServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Bonjour");
        CarServiceImpl carService = new CarServiceImpl();
        Car[] cars = {new Car("1-szz-614", "rouge", "Kia", "ceed", 2020), new Car("2-abc-741", "Blue", "Toyota", "Corolla", 2021)};
        carService.insertCars(cars);
        System.out.println(carService.findById("1-szz-614"));
        carService.findAllCars();
        carService.deleteCarById("1-szz-614");
        carService.findAllCars();
        Car newCar = carService.updateCar(new Car("2-abc-741", "bleu", "Toyata", "Yaris", 2015));
        System.out.println(newCar);
        Car greenCar = carService.updateCar(new Car("2-abc-741", "vert", "Toyata", "Yaris", 2015));
        System.out.println(greenCar);
    }
}