package DAO;

import java.sql.*;
import ErrorHandling.Error;

public class ConnectionFactory {

    private static String URL = "";
    private static String USER = "";
    private static String PASS = "";

    public static Connection getConnection() throws Error {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            if(e.getMessage().equals("The connection attempt failed.")){
                throw new Error("Authentication Failed", "ConnectionFactory", Error.Severity.LOW, e);
            } else if(e.getMessage().contains("Check that the hostname and port are correct and that the postmaster is accepting TCP/IP connections.")){
                throw new Error("Server couldn't be reached.", "ConnectionFactory", Error.Severity.LOW, e);
            } else {
                throw new Error("Unknown error.", "ConnectionFactory", Error.Severity.HIGH, e);
            }
        }
        return conn;
    }

    public static void setConnectionConfiguration(String url, String user, String password) {
        URL = "jdbc:postgresql://" + url;
        USER = user;
        PASS = password;
    }
}
