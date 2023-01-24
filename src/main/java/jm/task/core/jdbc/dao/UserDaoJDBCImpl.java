//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//    Connection connection = Util.getConnection();
//
//    public UserDaoJDBCImpl() {
//
//    }
//
//    public void createUsersTable() {
//        try {
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("create table if not exists users " +
//                    "(id mediumint not null auto_increment, firstname varchar(64) not null, " +
//                    "lastname varchar(64) not null, age integer(3) not null, primary key (id));");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void dropUsersTable() {
//        try {
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("drop table if exists users;");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("insert into users(firstname, lastname, age) values (?, ?, ?)");
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setInt(3, age);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    public void removeUserById(long id) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id = ?;");
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    public List<User> getAllUsers() {
//        List<User> users = new ArrayList<>();
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from users;");
//            while(resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("firstname"));
//                user.setLastName(resultSet.getString("lastname"));
//                user.setAge(resultSet.getByte("age"));
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return users;
//    }
//
//    public void cleanUsersTable() {
//        try {
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("delete from users");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//}
