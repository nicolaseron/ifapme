package org.example.connection;

import java.sql.*;

public class Database {
    private static final String url = "jdbc:postgresql://localhost:5432/users";
    private static final String user = "postgres";
    private static final String password = "nico1512";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
