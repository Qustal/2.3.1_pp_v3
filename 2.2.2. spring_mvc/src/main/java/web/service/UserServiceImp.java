package web.service;

import web.dao.UserDAO;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

//    @Autowired
//    public UserServiceImp(UserDAOImp userDAOImp) {
//        this.userDAOImp = userDAOImp;
//    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUserList() {
        return userDAO.getUserList();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUserById(Long id) {
        userDAO.deleteUserById(id);
    }
}