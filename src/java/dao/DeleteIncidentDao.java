/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.DBConnection;

/**
 *
 * @author VTEC
 */
public class DeleteIncidentDao {
    
      public boolean deleteIncidentById(int id) {
        String sql = "DELETE FROM incident WHERE id = ?";
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
