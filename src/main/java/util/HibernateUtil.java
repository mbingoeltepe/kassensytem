package util;


import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.SQLException;

/**
 * Created by berard on 14.02.17.
 */
public class HibernateUtil {
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private static Logger logger = Logger.getLogger(HibernateUtil.class);
    private static SessionFactory sessionFactory;

    public HibernateUtil() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot load driver: " + DRIVER, e);
        }
    }

    public static SessionFactory getConnection() throws SQLException {
        try {
            disconnect();
        } catch (Exception e) {

        }
        connect();
        return sessionFactory;
    }

    private static void connect() throws SQLException {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(entity.User.class);
            logger.info("Hibernate Configuration loaded.");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            logger.info("Hibernate Service loaded");

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            logger.info("Connection to the database");
        } catch (Throwable ex) {
            logger.error("Initial SessionFactory creation failed. " + ex);
            logger.info("Connection failure");
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static void disconnect() throws SQLException {
        if (sessionFactory != null) {
            logger.info("Disconnect from the database");
//            sessionFactory.close();
            sessionFactory = null;
        }
    }
}
