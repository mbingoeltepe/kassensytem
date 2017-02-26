package service.interfaces;

import entity.User;

import java.util.List;

/**
 * Created by berard on 14.02.17.
 */
public interface IUserService {

    public User changeUserDaten(User user);
    public List<User> searchUser(User user);
    public void  addUserToDB(User user);
    public List<User> allUsers();
    public void removeUser(User user);
    public User findUserByID(User user);

}
