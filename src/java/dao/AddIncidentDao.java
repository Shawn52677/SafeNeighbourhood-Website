/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.AddIncidentBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author VTEC
 */
public class AddIncidentDao {
   
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

    public String addIncident(AddIncidentBean addIncidentBean) {
        loadDriver(jdbcDriver);
        Connection connection = getConnection();
        String result = "Data entered successfully";
        String sql = "INSERT INTO incident (TITLE, DESCRIPTION, LOCATION, REPORTED_BY) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, addIncidentBean.getTitle());
            ps.setString(2, addIncidentBean.getDescription());
            ps.setString(3, addIncidentBean.getLocation());
            ps.setString(4, addIncidentBean.getReportedBy());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            result = "Data insertion failed";
        }

        return result;
    }
}
