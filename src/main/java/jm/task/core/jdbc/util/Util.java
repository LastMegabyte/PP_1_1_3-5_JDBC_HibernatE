package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/pp_1_1_3-4_hibernate[taskjdbc]";
    private static final String userName = "root";
    private static final String password = "root";
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection successful");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection aborted");
            e.printStackTrace();
        }
        return connection;
    }
}
