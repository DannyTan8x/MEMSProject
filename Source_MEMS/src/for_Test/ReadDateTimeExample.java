package for_Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ReadDateTimeExample {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        // Define a variable to store the datetime data
        LocalDateTime dateTime = null;

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // SQL query to select datetime data
            String sql = "SELECT datetime_column FROM your_table WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, 1); // Example: setting a parameter for the query
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        // Retrieve the DATETIME data and store it in LocalDateTime
                        Timestamp timestamp = rs.getTimestamp("datetime_column");
                        if (timestamp != null) {
                            dateTime = timestamp.toLocalDateTime(); // Convert Timestamp to LocalDateTime
                        }
                    }
                }
            }

            // Output the retrieved LocalDateTime
            if (dateTime != null) {
                System.out.println("Retrieved datetime: " + dateTime);
            } else {
                System.out.println("No datetime data found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
