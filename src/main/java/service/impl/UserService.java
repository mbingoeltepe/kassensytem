package service.impl;

import dao.DAOFactory;
import dao.interfaces.IUserDAO;
import entity.User;
import service.interfaces.IUserService;

import java.util.List;

/**
 * Created by berard on 14.02.17.
 */
public class UserService implements IUserService {

    private IUserDAO iuserDAO = null;
    private DAOFactory factory = null;

    public UserService() {
        factory = DAOFactory.instance(DAOFactory.HIBERNATE);
        iuserDAO = factory.getUserDAO();
    }

    public UserService(IUserDAO iuserDAO) {
       this.iuserDAO = factory.getUserDAO();
    }


    public IUserDAO getIuserDAO() {
        return iuserDAO;
    }

    public User changeUserDaten(User user) {
        return this.iuserDAO.changeUserDaten(user);
    }

    public List<User> searchUser(User user) {
        return iuserDAO.findByUser(user);
    }

    public void addUserToDB(User user) {
        iuserDAO.insertUser(user);
    }

    public List<User> allUsers() {
        return null;
    }

    public void removeUser(User user) {

    }

    public User findUserByID(User user) {
        return this.iuserDAO.findById(user.getId());
    }
}
