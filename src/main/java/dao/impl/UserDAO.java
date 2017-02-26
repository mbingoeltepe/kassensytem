package dao.impl;

import dao.DAOFactory;
import dao.GenericHibernateDAO;
import dao.interfaces.IUserDAO;
import entity.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by berard on 14.02.17.
 */
public class UserDAO extends GenericHibernateDAO<User, Integer> implements IUserDAO {

    private IUserDAO iuserDAO = null;
    private DAOFactory factory = null;


    public UserDAO() {

    }

    /**
     * Aramalarda aranacak kelimenin sonuna '*' yildiz isareti konulur.
     * Ve bütün sonuclar listelenir.
     * Örnegin: Mu yazildiginda sonuna '*' yildiz isareti konulur.
     * Database de Murat bilgisi geri gönderilir.
     * @param u
     * @return Gefundene Users
     */
    public List<User> findByUser(User u) {
        setDAOFactroyActive();
        setTransactionActive();
        CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> rootUser = query.from(User.class);

        List<Predicate> wherePredicates = new ArrayList<Predicate>();

        if (u.getName() != null) {
            String name = u.getName().replace('*','%').replace('?',' ')
                    .toUpperCase();
            wherePredicates.add(builder.like(
                    builder.upper(rootUser.<String> get("name")), name));
        }

        Predicate whereClause = builder.and(wherePredicates
                    .toArray(new Predicate[0]));
        query.where(whereClause);

        return this.getSession().createQuery(query).getResultList();
    }

    public User changeUserDaten(User u) {
        setDAOFactroyActive();
        User user = new User();
        user = findById(u.getId());
        user = iuserDAO.persistOrMerge(u);

        return user;
    }

    public void insertUser(User u) {
        setDAOFactroyActive();
        iuserDAO.persistOrMerge(u);

    }

    public User findUser (User u) {

        setDAOFactroyActive();
        User user = iuserDAO.findById(u.getId());

        return user;

    }

    public void setDAOFactroyActive() {
        factory = DAOFactory.instance(DAOFactory.HIBERNATE);
        iuserDAO = factory.getUserDAO();

    }


}
