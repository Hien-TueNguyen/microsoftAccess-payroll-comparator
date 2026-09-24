package com.payrollcomparison;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        
        Path databasePath = Path.of("sample_data/test_payroll.accdb");

        try (Connection connection = AccessDatabaseConnection.open(databasePath)) {
            System.out.println("Successfully connected to the database.");
            // You can perform database operations here using the 'connection' object.
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database: " + e.getMessage());
        }
    }
}
