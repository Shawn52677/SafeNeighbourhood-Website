/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import bean.LoginBean;
import java.sql.*;
import model.DBConnection;
/**
 *
 * @author VTEC
 */
public class LoginDao {
    
    public String authenticateUser(LoginBean loginBean){
        
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();
        
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        String usernameDB ="";
        String passwordDB ="";
        
        try {
            conn = DBConnection.getConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery("Select username, password from users");
            
            while(resultSet.next()){
                usernameDB = resultSet.getString("username");
                passwordDB = resultSet.getString("password");
                if(username.equals(usernameDB) && password.equals(passwordDB)){
                    return "SUCCESS";
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }
}
