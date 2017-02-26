package dao.interfaces;

import dao.GenericDAO;
import entity.User;

import java.util.List;

/**
 * Created by berard on 14.02.17.
 */
public interface IUserDAO extends GenericDAO<User, Integer> {

    public List<User> findByUser(User u);
    public User changeUserDaten(User u);
    public void insertUser(User u);
}
