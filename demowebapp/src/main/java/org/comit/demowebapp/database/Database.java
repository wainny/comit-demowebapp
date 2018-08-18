package org.comit.demowebapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Found JDBC Driver!");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.err.println("Could not find JDBC Driver.");
            }

            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/demowebapp",
                        "root",
                        "password"
                );
                System.out.println("Successfully connected to the DB!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Cannot connect to the DB.");
            }
        }

        return connection;
    }
}
