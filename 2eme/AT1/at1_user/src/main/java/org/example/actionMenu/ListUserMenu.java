package org.example.actionMenu;

import org.example.MainMenu.BaseMenu;
import org.example.connection.Database;
import org.example.exception.BusinessException;
import org.example.model.User;

import java.sql.*;

public class ListUserMenu extends BaseMenu {

    @Override
    public void execute() {
        try (Connection connection = Database.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM \"user\"");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " : " + resultSet.getString("firstname") + " " + resultSet.getString("lastname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        continueMessage();
    }

    @Override
    public void execute(User user) throws BusinessException {

    }
}

