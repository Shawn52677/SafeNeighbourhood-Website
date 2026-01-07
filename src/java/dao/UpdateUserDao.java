/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.UpdateUserBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author VTEC
 */
public class UpdateUserDao {
    
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

    public String updateUser(UpdateUserBean updateUserBean) {
        loadDriver(jdbcDriver);
        Connection connection = getConnection();
        String result = "Data entered successfully";
        String sql = "SELECT * FROM users";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, updateUserBean.getId());
            ps.setString(2, updateUserBean.getUsername());
            ps.setString(3, updateUserBean.getPassword());
            ps.setString(4, updateUserBean.getRole());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            result = "Data insertion failed";
        }

        return result;
    }
    
}
