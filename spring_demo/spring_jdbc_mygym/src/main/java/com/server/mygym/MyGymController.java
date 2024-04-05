package com.server.mygym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
@RestController
public class MyGymController {

    static String DB_URL = "jdbc:mysql://localhost/MYGYM";
    static String USER = "root";
    static String PWD = "mysqlte$t001";
    static String QUERY_MEMBER = "SELECT * FROM MEMBER;";
    public static void main(String[] args) {
        SpringApplication.run(MyGymController.class, args);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/mygym")
    public String index() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{ \"members\" = [");
        try {
            Connection dbconn = DriverManager.getConnection(DB_URL, USER, PWD);
            Statement stmnt = dbconn.createStatement();
            System.out.println("Attempting to run query: " + QUERY_MEMBER);
            ResultSet rs = stmnt.executeQuery(QUERY_MEMBER);
            boolean hasRows = false;
            while (rs.next()) {
                // Just print the first and last names
                buffer.append("{");
                buffer.append(String.format("\"memberId\": \"%s\",", rs.getString(1)));
                buffer.append(String.format("\"firstName\": \"%s\",", rs.getString(2)));
                buffer.append(String.format("\"lastName\": \"%s\"", rs.getString(3)));
                buffer.append("},");
                hasRows = true;
            }
            //delete trailing comma
            if (hasRows) {
                buffer.deleteCharAt(buffer.lastIndexOf(","));
            }
        } catch (Exception e) {
            return String.format("{\"error\": \"%s\"}", e.getMessage());
        }
        return buffer.append("]}").toString();
    }
}
