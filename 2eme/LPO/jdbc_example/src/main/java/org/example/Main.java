package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // Info de la connexion
        String url = "jdbc:postgresql://localhost:5432/airbnb";
        String user = "postgres";
        String password = "nico1512";
        String query = "INSERT INTO \"user\" (id, firstname) VALUES (? , ?)";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, 3);
//            preparedStatement.setString(2, "Bastien");
//            preparedStatement.execute();

            String selectSql = "SELECT * FROM \"user\"";
            PreparedStatement selectStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                System.out.println("id " + id + " firstname " + firstname);
            }

            String selectByIdSql = "SELECT * FROM \"user\" WHERE \"id\" = ?";
            PreparedStatement selectByIdStatement = connection.prepareStatement(selectByIdSql);
            selectByIdStatement.setInt(1, 1);
            ResultSet resultSetById = selectByIdStatement.executeQuery();
            while (resultSetById.next()) {
                String firstname = resultSetById.getString("firstname");
                int id = resultSetById.getInt("id");
                System.out.println("id " + id + " firstname " + firstname);
            }

            String updateSql = "UPDATE \"user\" SET firstname = ? WHERE \"id\" = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateSql);
            updateStatement.setString(1, "Jean");
            updateStatement.setInt(2, 1);
            updateStatement.execute();

            String deleteSql = "DELETE FROM \"user\" WHERE \"id\" = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
            deleteStatement.setInt(1, 3);
            deleteStatement.execute();
            deleteStatement.close();

            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}