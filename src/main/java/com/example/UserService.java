package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class UserService {

    // SECURITY ISSUE: Hardcoded credentials
    private String password = "admin123";

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    // VULNERABILITY: SQL Injection
    public void findUser(String username) throws java.sql.SQLException {

        String sql = "SELECT id, name, email FROM users WHERE name = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db",
                "root", password);
             java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);

            try (java.sql.ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // process result if needed
                }
            }
        }
    }

    // SMELL: Unused method
    public void notUsed() {
        LOGGER.info("I am never called");
    }
}