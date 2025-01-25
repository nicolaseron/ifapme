package org.example.repository;

import org.example.database.DatabaseConnection;
import org.example.exception.ForbidenColor;
import org.example.model.Car;

import java.sql.*;

public class CarRepository {
    Connection connection;

    public CarRepository() throws SQLException {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public void insertCars(Car[] cars) throws SQLException {
        for (Car car : cars) {
            createCar(car);
        }
    }

    private void createCar(Car car) throws SQLException {
        String sql = "INSERT INTO car VALUES (?, ?, ?, ?, ?)";
        try {
            if (car.getColor().equalsIgnoreCase("vert")) {
                throw new ForbidenColor();
            }
            if (findById(car.getPlate()) != null) {
                return;
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, car.getPlate());
            preparedStatement.setString(2, car.getColor());
            preparedStatement.setString(3, car.getBrand());
            preparedStatement.setString(4, car.getModel());
            preparedStatement.setInt(5, car.getRegistrationYear());
            preparedStatement.execute();
        } catch (SQLException | ForbidenColor e) {
            throw new RuntimeException(e);
        }
    }

    public Car findById(String plate) {
        String sql = "SELECT * FROM car WHERE plate = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, plate);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("La voiture a été trouvée.");
                String color = resultSet.getString("color");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                int registrationYear = resultSet.getInt("registration_year");
                return new Car(plate, color, brand, model, registrationYear);
            } else {
                System.out.println("La voiture n'a pas été trouvée.");
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void findAllCars() {
        String sql = "SELECT * FROM car";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String plate = resultSet.getString("plate");
                String color = resultSet.getString("color");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                int registrationYear = resultSet.getInt("registration_year");
                Car car = new Car(plate, color, brand, model, registrationYear);
                System.out.println(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCarById(String plate) {
        String sql = "DELETE FROM car WHERE plate = ?";
        try {
            Car car = findById(plate);
            if (car == null) {
                return;
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, plate);
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("La voiture a bien été supprimée.");
            } else {
                System.out.println("La voiture n'a pas été trouvée.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Car updateCar(Car car) {
        String sql = "UPDATE car SET color = ?, brand = ?, model = ?, registration_year = ? WHERE plate = ?";
        try {
            if (car.getColor().equalsIgnoreCase("vert")) {
                throw new ForbidenColor();
            }
            Car carToUpdate = findById(car.getPlate());
            if (carToUpdate == null) {
                return null;
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, car.getColor());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setString(3, car.getModel());
            preparedStatement.setInt(4, car.getRegistrationYear());
            preparedStatement.setString(5, car.getPlate());
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("La voiture a bien été modifiée.");
            } else {
                System.out.println("La voiture n'a pas été trouvée.");
            }
            return car;
        } catch (SQLException | ForbidenColor e) {
            throw new RuntimeException(e);
        }
    }
}