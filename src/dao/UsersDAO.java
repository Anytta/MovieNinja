package dao;

import model.User;

import java.util.List;

public interface UsersDAO {

    List<User> getAllUsers();
    User getUserByLogin(String login);
    void createUsers(User user);
    void updateUser(User user);
    void deleteUser(String login);
}


