package org.example.service;

import org.example.model.User;
import org.example.connection.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.connection.Database.getConnection;

public class UserService {

    public void deleteUser(int userId) {
        try {
            Connection connection = Database.getConnection();
            String sql = "DELETE FROM \"user\" WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.execute();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createUser(String firstname, String lastname) {
        try {
            Connection connection = Database.getConnection();

            String sql = "INSERT INTO \"user\" (firstname, lastname) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.execute();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(int userId, String firstname, String lastname) {
        try {
            Connection connection = Database.getConnection();
            String sql = "UPDATE \"user\" SET firstname = ?, lastname = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.setInt(3, userId);
            statement.execute();
            statement.close();
            System.out.println("Utilisateur modifié avec succès!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isUserExist(int userId) {
        String query = "SELECT COUNT(*) FROM \"user\" WHERE id = ?";
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUserByUsername(String username) {
        String query = "SELECT * FROM \"user\" WHERE username = ?";

        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertPasswordForCurrentUser(String username, String password) {
        try {
            Connection connection = Database.getConnection();

            String sql = "UPDATE \"user\" SET password = ? WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, password);
            statement.setString(2, username);
            statement.execute();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

