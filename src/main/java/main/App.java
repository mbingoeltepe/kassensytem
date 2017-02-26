package main;

import entity.User;
import service.impl.UserService;
import service.interfaces.IUserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by berard on 14.02.17.
 */
public class App {


    public static void main(String[] args) {
        IUserService userService = null;
        userService = new UserService();
/*
 //    Add User
        User user = new User();
        user.setName("Mustafa");
        user.setPassword("6666");

        userService.addUserToDB(user);

*/

//      Change User
        User user = new User();
        user.setId(8);
        user.setName("Egemmmmmm");
        user.setPassword("2222222222");

        user = userService.changeUserDaten(user);


/*
// List All
        User user = new User();
        user.setName("M*");

        List<User> users = new ArrayList<User>();

        users = userService.searchUser(user);

*/
        System.out.println(user);

    }
}
