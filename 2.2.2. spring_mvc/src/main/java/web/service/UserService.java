package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void deleteUserById(Long id);
    User getUserById(Long id);
    List<User> getUserList();
    void updateUser(User user);
}
