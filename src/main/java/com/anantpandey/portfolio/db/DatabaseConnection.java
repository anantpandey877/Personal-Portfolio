package com.anantpandey.portfolio.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // --- Database Connection Details ---
    // Make sure to use your database name in the URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/portfolio_db";
    private static final String DB_USER = "root";
    // !!! IMPORTANT: Replace with your actual MySQL root password !!!
    private static final String DB_PASSWORD = "root";

    /**
     * Establishes a connection to the database.
     * @return A Connection object or null if connection fails.
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // 1. Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2. Create the connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database connection failed!");
            e.printStackTrace();
        }
        return connection;
    }
}