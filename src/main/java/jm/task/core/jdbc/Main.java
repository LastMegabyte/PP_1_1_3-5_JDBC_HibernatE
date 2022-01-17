package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        List<User> users = new ArrayList<>();
        users.add(new User("User1", "Lastname1", (byte) 19));
        users.add(new User("User2", "Lastname2",  (byte) 20));
        users.add(new User( "User3", "Lastname3", (byte) 21));
        users.add(new User("User4", "Lastname4", (byte) 22));
        users.forEach(u -> {
            userService.saveUser(u.getName(), u.getLastName(), u.getAge());
            System.out.format("User с именем – %s добавлен в базу данных%n", u.getName());
        });
        userService.getAllUsers().forEach(user -> System.out.println(user.toString()));
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
