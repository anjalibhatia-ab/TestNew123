package com.example.securitylab;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Demonstrates a database access pattern for security review.
 */
public final class UserRepository {
    private final Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    /**
     * INTENTIONAL VULNERABILITY: username is concatenated into SQL.
     * Use a PreparedStatement with a bound parameter in real applications.
     */
    public String findByUsername(String username) throws SQLException {
        String sql = "SELECT display_name FROM users WHERE username = '" + username + "'";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                return resultSet.getString("display_name");
            }
            return null;
        }
    }
}
