package mygym.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnect {

    static String DB_URL = "jdbc:mysql://localhost/MYGYM";
    static String USER = "root";
    static String PWD = "mysqlte$t001";
    static String QUERY_MEMBER = "SELECT * FROM MEMBER;";

    public static void main(String[] args) {
        try {
            /*
             * Class.forName("com.mysql.jdbc.Driver");
             * Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver
             * class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered
             * via the SPI and manual loading of the driver class is generally unnecessary.
             */
            Connection dbconn = DriverManager.getConnection(DB_URL, USER, PWD);
            Statement stmnt = dbconn.createStatement();
            System.out.println("Attempting to run query: " + QUERY_MEMBER);
            ResultSet rs = stmnt.executeQuery(QUERY_MEMBER);
            while (rs.next()) {
                // Just print the first and last names
                System.out.println(rs.getString(2) + " " + rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("Exception while connecting to database: " + e);
        }

    }
}