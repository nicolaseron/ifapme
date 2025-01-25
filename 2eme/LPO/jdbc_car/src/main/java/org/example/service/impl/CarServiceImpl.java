package org.example.service.impl;

import org.example.invalidCarException.*;
import org.example.model.Car;
import org.example.service.CarService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {
    private final Connection connection;

    public CarServiceImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertCar(Car car) throws BusinessException {
        if (car.getId() == null || car.getColor().isEmpty() || car.getModel().isEmpty()) {
            throw new CarInvalidInputException();
        }
        if (car.getColor().equalsIgnoreCase("rose")) {
            throw new CarColorException();
        }
        if (findById(car.getId()) != null) {
            throw new CarAlreadyExistException(car.getId());
        }
        String sql = "INSERT INTO car VALUES (?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, car.getId());
            statement.setString(2, car.getColor());
            statement.setString(3, car.getModel());
            statement.execute();
            statement.close();
            System.out.println("La voiture a bien été ajoutée.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Car> findAll() {
        String sql = "SELECT * FROM car";
        List<Car> cars = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String color = resultSet.getString("color");
                String model = resultSet.getString("model");
                Car car = new Car(id, color, model);
                cars.add(car);
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

    @Override
    public Car findById(Integer id) {
        String sql = "SELECT * FROM car WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int carId = resultSet.getInt("id");
                String color = resultSet.getString("color");
                String model = resultSet.getString("model");
                resultSet.close();
                return new Car(carId, color, model);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void updateCar(Car car) throws BusinessException {
        if (car.getId() == null || car.getColor().isEmpty() || car.getModel().isEmpty()) {
            throw new CarNotFoundException(car.getId());
        }
        if (car.getColor().equals("rose")) {
            throw new CarColorException();
        }
        try {
            String sql = "UPDATE car SET color = ?, model = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, car.getColor());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setInt(3, car.getId());
            preparedStatement.execute();
            preparedStatement.close();
            System.out.println("La voiture a bien été modifiée.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCar(Car car) throws BusinessException {
        if (findById(car.getId()) == null) {
            throw new CarNotFoundException(car.getId());
        }
        try {
            String sql = "DELETE FROM car WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, car.getId());
            preparedStatement.execute();
            preparedStatement.close();
            System.out.println("La voiture a bien été supprimée.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
