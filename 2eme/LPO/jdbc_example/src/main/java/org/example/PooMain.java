package org.example;

import org.example.invalidUserException.UserNotFoundException;
import org.example.model.User;
import org.example.service.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class PooMain {
    public static void main(String[] args) throws SQLException, UserNotFoundException {

        String url = "jdbc:postgresql://localhost:5432/airbnb";
        String user = "postgres";
        String password = "nico1512";
        Connection connection = DriverManager.getConnection(url, user, password);

        UserService userService = new UserService(connection);
        User userToCreate = new User(2, "Jean");
        if (userService.findById(userToCreate.getId()) == null) {
            userService.addUser(userToCreate);
        }

        List<User> users = userService.findAll();
        users.forEach(user1 -> System.out.println("id = " + user1.getId() + " firstname : " + user1.getFirstname()));

        User userById = userService.findById(1);
        System.out.println("ID = " + userById.getId() + " firstname : " + userById.getFirstname());

        userById.setFirstname("Nico");
        User userUpdate = userService.updateUser(userById);
        if (userUpdate != null) {
            System.out.println("L'update s'est bien passé");
        }
//        userService.deleteById(userUpdate);
        connection.close();
    }
}
