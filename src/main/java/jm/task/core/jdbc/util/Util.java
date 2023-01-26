package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/pp_1_1_3-4_hibernate[taskjdbc]";
    private static final String userName = "root";
    private static final String password = "root";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static SessionFactory sessionFactory;

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
