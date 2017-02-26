package dao;

import dao.impl.UserDAO;
import dao.interfaces.IUserDAO;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.sql.SQLException;

/**
 * Created by berard on 14.02.17.
 */
public class DAOHibernateFactory extends DAOFactory{
    private static Logger logger = Logger.getLogger(DAOHibernateFactory.class);

    private GenericHibernateDAO instantiateDAO(Class daoClass) {
        try {
            GenericHibernateDAO dao = (GenericHibernateDAO)daoClass.newInstance();
            dao.setSession(getCurrentSession());
            logger.info("Instantiate DAO: " + daoClass);
            return dao;
        } catch (Exception ex) {
            logger.error("Can not instantiate DAO: " + daoClass + ex);
            throw new RuntimeException();
        }
    }

    protected Session getCurrentSession() throws HibernateException, SQLException  {
        return HibernateUtil.getConnection().getCurrentSession();
    }

//    protected Session getCurrentSession() {
//         // return SessionUtil.getSessionFactory().getCurrentSession();
//
//        SessionFactory sessionFactory = null;
//        try {
//            sessionFactory = HibernateUtil.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return (Session) sessionFactory;
//
// }

    @Override
    public IUserDAO getUserDAO() {
        return (IUserDAO)instantiateDAO(UserDAO.class);
    }

}
