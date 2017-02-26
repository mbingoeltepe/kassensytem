package dao;

import dao.interfaces.IUserDAO;
import org.apache.log4j.Logger;

/**
 * Created by berard on 14.02.17.
 */
public abstract class DAOFactory {

    private static Logger logger = Logger.getLogger(DAOFactory.class);

    public static final Class HIBERNATE = DAOHibernateFactory.class;

    public static DAOFactory instance(Class factory) {
        try {
            logger.info("DAOFactory created: " + factory);
            return (DAOFactory)factory.newInstance();
        } catch (Exception ex) {
            logger.error("Couldn't create DAOFactory: " + factory);
            throw new RuntimeException();
        }

    }

    // To do DAO Interfaces
     public abstract IUserDAO getUserDAO();

}
