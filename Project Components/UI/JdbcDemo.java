import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:student.db"; // Example using SQLite
        String createTableSQL = "CREATE TABLE IF NOT EXISTS student (id INTEGER PRIMARY KEY, name TEXT)";
        String insertSQL = "INSERT INTO student (id, name) VALUES (?, ?)";
        String selectSQL = "SELECT * FROM student";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            // Step 2: Create table
            stmt.execute(createTableSQL);

            // Step 3: Insert rows using PreparedStatement
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                pstmt.setInt(1, 1);
                pstmt.setString(2, "Alice");
                pstmt.executeUpdate();

                pstmt.setInt(1, 2);
                pstmt.setString(2, "Bob");
                pstmt.executeUpdate();
            }

            // Step 4: Query and print rows
            try (ResultSet rs = stmt.executeQuery(selectSQL)) {
                System.out.println("Student Table:");
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
                }
            }

        }
        catch (SQLException e)
        {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}