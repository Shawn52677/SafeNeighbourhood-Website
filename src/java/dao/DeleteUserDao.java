package dao;
import bean.DeleteUserBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.DBConnection;

public class DeleteUserDao {

    public boolean deleteUserById(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DBConnection.getConnection(); // Get database connection
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, id); // Set the ID parameter
            int rowsAffected = pst.executeUpdate(); // Execute the query

            return rowsAffected > 0; // Return true if a row was deleted
        } catch (SQLException e) {
            e.printStackTrace(); // Log SQL exception
            return false; // Return false if an error occurs
        }
    }
}