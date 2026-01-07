package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:derby://localhost:1527/SafeNeighbourhoodDB;create=true";  // Replace with your database URL
        String username = "app";  // Replace with your database username
        String password = "app"; 
        try {
           try{
               Class.forName("org.apache.derby.jdbc.ClientDriver");
           }
           catch (ClassNotFoundException e){
                e.printStackTrace();
           }
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful" + conn);
            } 
            catch (Exception e) {
            e.printStackTrace();
            }
            return conn;
    }
}
