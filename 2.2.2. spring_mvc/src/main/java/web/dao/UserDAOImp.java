package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUserList() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("select u from User u");
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User getUserById(Long id) {
        return sessionFactory.getCurrentSession().load(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteUserById(Long id) {
        sessionFactory.getCurrentSession().delete(getUserById(id));
    }
}
