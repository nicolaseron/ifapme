package org.example.service;

import org.example.invalidUserException.UserNotFoundException;
import org.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private Connection connection;

    public UserService(Connection connection) {
        this.connection = connection;
    }

    public void addUser(User user) throws SQLException {
        String insertSql = "INSERT INTO \"user\" (id, firstname) VALUES (? , ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setInt(1, user.getId());
        preparedStatement.setString(2, user.getFirstname());
        preparedStatement.execute();
        preparedStatement.close();
    }

    public List<User> findAll() throws SQLException {
        String selectSql = "SELECT * FROM \"user\"";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstname = resultSet.getString("firstname");
            User user = new User(id, firstname);
            users.add(user);
        }
        preparedStatement.close();
        return users;
    }

    public User findById(int id) throws SQLException, UserNotFoundException {
        String selectSql = "SELECT * FROM \"user\" WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            User user = new User(resultSet.getInt("id"), resultSet.getString("firstname"));
            preparedStatement.close();
            return user;
        } else {
            preparedStatement.close();
            throw new UserNotFoundException("L'user n'a pas été trouvé.");
        }
    }

    public void deleteById(User user) throws SQLException, UserNotFoundException {
        String deleteSql = "DELETE FROM \"user\" WHERE id = ?";
        if (findById(user.getId()) != null) {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } else {
            throw new UserNotFoundException("L'user n'a pas été trouvé.");
        }
    }

    public User updateUser(User user) throws SQLException, UserNotFoundException {
        String updateSql = "UPDATE \"user\" SET firstname = ? WHERE id = ?";
        if (findById(user.getId()) != null) {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setInt(2, user.getId());
            preparedStatement.execute();
            preparedStatement.close();
            return user;
        } else {
            throw new UserNotFoundException("L'user n'a pas été trouvé.");
        }
    }
}
