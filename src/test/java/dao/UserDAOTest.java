package dao;

import dao.impl.UserDAO;
import dao.interfaces.IUserDAO;
import entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by berard on 21.02.17.
 */
public class UserDAOTest {

    public IUserDAO userDAO = null;

    @Before
    public void setUp() throws Exception {
        userDAO = new UserDAO();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void findByUser() throws Exception {

    }

    @Test
    public void changeUserDaten() throws Exception {

    }

    @Test
    public void insertUser() throws Exception {
        User user = new User();
        user.setName("Mustafa");
        user.setPassword("6666");

        userDAO.insertUser(user);
    }

    @Test
    public void findUser() throws Exception {

    }

    @Test
    public void setDAOFactroyActive() throws Exception {

    }

}