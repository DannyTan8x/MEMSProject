package for_Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateTimeExample {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Insert a LocalDateTime value into the database
            String insertSql = "INSERT INTO your_table (datetime_column) VALUES (?)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                LocalDateTime now = LocalDateTime.now();
                insertStmt.setTimestamp(1, Timestamp.valueOf(now)); // Convert LocalDateTime to Timestamp
                insertStmt.executeUpdate();
                System.out.println("Inserted datetime: " + now);
            }

            // Retrieve the LocalDateTime value from the database
            String selectSql = "SELECT datetime_column FROM your_table";
            try (PreparedStatement selectStmt = conn.prepareStatement(selectSql);
                 ResultSet rs = selectStmt.executeQuery()) {
                while (rs.next()) {
                    LocalDateTime dateTime = rs.getTimestamp("datetime_column").toLocalDateTime(); // Convert Timestamp to LocalDateTime
                    System.out.println("Retrieved datetime: " + dateTime);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

