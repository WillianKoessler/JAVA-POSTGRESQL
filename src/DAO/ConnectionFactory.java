package DAO;


public class ConnectionFactory {

    private static String URL = "";//"jdbc:postgresql://192.168.15.117:5432/4385 - Willian Koessler";
    private static String USER = "";//"postgres";
    private static String PASS = "";//"10203";

    public static java.sql.Connection getConnection() throws java.sql.SQLException {
            return java.sql.DriverManager.getConnection(URL, USER, PASS);
    }

    public static void Configure(String address, String database, String user, String password) {
        URL = "jdbc:postgresql://" + address + "/" + database;
        USER = user;
        PASS = password;
    }
}
