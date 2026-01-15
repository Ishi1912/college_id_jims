package com.collegeid.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    // Private constructor to prevent object creation
    private DB() { }

    // Static method to create a database connection
    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        // Step 1: Load MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Step 2: Create connection
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college_id", // Database name
                "root",                                     // DB username
                "Ishi@1912"                                          // DB password
        );

        if (connection != null) {
            System.out.println("Connection created successfully...");
        }

        return connection;
    }

    // Optional: quick test
    /*public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DB.createConnection();
    }*/
}
