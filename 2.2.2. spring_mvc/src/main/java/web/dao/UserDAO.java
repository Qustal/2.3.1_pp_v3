package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    void updateUser(User user);

    List<User> getUserList();

    User getUserById(Long id);

    void deleteUserById(Long id);

    void addUser(User user);
}
