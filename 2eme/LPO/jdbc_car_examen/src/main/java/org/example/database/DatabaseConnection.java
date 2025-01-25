package org.example.database;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private final Connection connection;

    private DatabaseConnection() throws SQLException {
        try {
            final String url = "jdbc:postgresql://localhost:5432/jdbc_car";
            final String user = "postgres";
            final String password = "nico1512";
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new SQLException("Erreur lors de la connexion à la base de données.", e);
        }
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
            return instance;
        }
        return instance;
    }
}

