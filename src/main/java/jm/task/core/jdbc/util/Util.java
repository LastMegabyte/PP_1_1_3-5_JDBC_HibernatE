package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/pp_1_1_3-4_hibernate[taskjdbc]";
    private static final String userName = "root";
    private static final String password = "root";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static SessionFactory sessionFactory;

//    public static Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName(driver);
//            connection = DriverManager.getConnection(url, userName, password);
//            System.out.println("Connection successful");
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println("Connection aborted");
//            e.printStackTrace();
//        }
//        return connection;
//    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties set = new Properties();
                set.put(Environment.DRIVER, driver);
                set.put(Environment.URL, url);
                set.put(Environment.USER, userName);
                set.put(Environment.PASS, password);
                configuration.setProperties(set);
                configuration.addAnnotatedClass(User.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
