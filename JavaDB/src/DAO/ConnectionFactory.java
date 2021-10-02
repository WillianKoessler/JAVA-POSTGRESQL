/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;

/**
 *
 * @author willian
 */
public class ConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost:5433/postgres";
    private static String USER = "postgres";
    private static final String PASS = "123456";
    
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch(SQLException e){
            System.out.println("CONNECTIONFACTORY ERROR: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
