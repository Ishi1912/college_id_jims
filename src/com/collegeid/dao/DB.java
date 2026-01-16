package com.collegeid.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private DB() { }

    // Static method to create a database connection
    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college_id",
                "root",
                "Ishi@1912"
        );

        if (connection != null) {
            System.out.println("Connection created successfully...");
        }

        return connection;
    }
}
