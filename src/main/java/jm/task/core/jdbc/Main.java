package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {


        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        List<User> usersList2 = new ArrayList<>();
        usersList2.add(new User("User5", "Lastname1", (byte) 19));
        usersList2.add(new User("User6", "Lastname2",  (byte) 20));
        usersList2.add(new User( "User7", "Lastname3", (byte) 21));
        usersList2.add(new User("User8", "Lastname4", (byte) 22));
        usersList2.forEach(u -> {
            userService.saveUser(u.getName(), u.getLastName(), u.getAge());
            System.out.format("User с именем – %s добавлен в базу данных%n", u.getName());
        });
        userService.getAllUsers().forEach(user -> System.out.println(user.toString()));
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
