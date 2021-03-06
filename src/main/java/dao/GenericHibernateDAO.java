package dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by berard on 14.02.17.
 */
public abstract class GenericHibernateDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

    private static Logger logger = Logger.getLogger(GenericHibernateDAO.class);

    protected Class<T> persistentClass = null;
    protected Session session = null;
    protected Transaction transaction = null;
    protected String findAllQueryString = null;
    protected String countQueryString = null;
    protected String removeAllString = null;

    public GenericHibernateDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        this.findAllQueryString = "SELECT e FROM " + this.persistentClass.getSimpleName() + " e";
    }

    public Session getSession() {
        if (session == null) {
            logger.info("Session has not been set on DAO before usage");
            throw new IllegalStateException();
        }
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public T persistOrMerge(T entity) {
        setTransactionActive();
        this.session.saveOrUpdate(entity);
        transaction.commit();
        return entity;
    }

    public void delete(T entity) {
        // TODO Auto-generated method stub

    }


    public T findById(ID id) {
        setTransactionActive();
        return this.session.find(this.persistentClass,id);
    }

    public List<T> findAll() {

        return this.session.createQuery(this.findAllQueryString).getResultList();
    }

    public void setTransactionActive() {
        transaction = this.session.getTransaction();
        transaction.begin();
    }





}

