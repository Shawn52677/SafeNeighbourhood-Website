/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ViewIncidentBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author VTEC
 */
public class ViewIncidentDao {
    
    private String jdbcURL = "jdbc:derby://localhost:1527/SafeNeighbourhoodDB";
    private String jdbcUsername = "app";
    private String jdbcPassword = "app";
    private String jdbcDriver = "org.apache.derby.jdbc.ClientDriver";

    public void loadDriver(String driver) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public String viewIncident(ViewIncidentBean viewIncidentBean) {
        loadDriver(jdbcDriver);
        Connection connection = getConnection();
        String result = "Data entered successfully";
        String sql = "SELECT * FROM incident";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, viewIncidentBean.getTitle());
            ps.setString(2, viewIncidentBean.getDescription());
            ps.setString(3, viewIncidentBean.getLocation());
            ps.setString(4, viewIncidentBean.getReportedBy());
            ps.setString(5, viewIncidentBean.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            result = "Data insertion failed";
        }

        return result;
    }
}
