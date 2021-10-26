package DAO;

import java.sql.*;

public class ConnectionFactory {
    private static final String URL = "jdbc:postgresql://192.168.15.117:5432/4385 - Willian Koessler";
    private static final String USER = "postgres";
    private static final String PASS = "10203";
    
    public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASS);
    }
    public static void Configure(String address, String port, String database, String user, String password){
        URL = "jdbc:postgresql://" + address + ":" + port + "/" + database;
    }
}
