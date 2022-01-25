package it.unicam.cs.mgm.casotto.connettori;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","root");
        } catch (Exception e) {
            connection = null;
        }
        return connection;
    }

}