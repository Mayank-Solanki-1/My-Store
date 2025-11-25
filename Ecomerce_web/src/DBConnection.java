package com.ecommerce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce_db";
    private static final String USER = "root";
    private static final String PASS = "password"; // UPDATE THIS TO YOUR MYSQL PASSWORD

    public static Connection getConnection() {
        Connection con = null;
        try {
            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found. Add mysql-connector-java.jar to lib.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection Failed. Check DB URL, User, or Password.");
            e.printStackTrace();
        }
        return con;
    }
}