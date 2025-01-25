package org.example;

import org.example.invalidCarException.BusinessException;
import org.example.model.Car;
import org.example.service.impl.CarServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException , BusinessException {
        String url = "jdbc:postgresql://localhost:5432/airbnb";
        String user = "postgres";
        String password = "nico1512";
        Connection connection = DriverManager.getConnection(url, user, password);

        CarServiceImpl carService = new CarServiceImpl(connection);

        Car kia = new Car(1, "blanc", "Kia ceed");
        carService.insertCar(kia);

        Car peugeot = new Car(2, "bleu", "Peugeot 2008");
        carService.insertCar(peugeot);

        Car Fiat = new Car(3, "rouge", "Fiat 500");
        carService.insertCar(Fiat);

        List<Car> cars = carService.findAll();
        System.out.println(cars);

        Car car = carService.findById(2);
        System.out.println(car);
        if (car != null) {
            car.setColor("blanc");
            car.setModel("Citroen c3");
            carService.updateCar(car);
        }

        car = carService.findById(2);
        System.out.println(car);

        carService.deleteCar(car);
        cars = carService.findAll();
        System.out.println(cars);
    }
}