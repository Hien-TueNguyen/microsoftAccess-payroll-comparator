package com.payrollcomparison;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Opens connections to Microsoft Access databases through UCanAccess. */
public final class AccessDatabaseConnection {
    private AccessDatabaseConnection() {
    }

    /**
     * Opens a connection that the caller must close.
     *
     * <pre>
     * try (Connection connection = AccessDatabaseConnection.open(Path.of("data/payroll.accdb"))) {
     *     // Use the connection here.
     * }
     * </pre>
     *
     * @param databasePath path to an .accdb or .mdb file
     * @return an open database connection
     * @throws SQLException if the database cannot be opened
     */
    public static Connection open(Path databasePath) throws SQLException {
        String normalizedPath = databasePath.toAbsolutePath()
                .normalize()
                .toString()
                .replace('\\', '/');
        String jdbcUrl = "jdbc:ucanaccess://" + normalizedPath;
        return DriverManager.getConnection(jdbcUrl);
    }
}