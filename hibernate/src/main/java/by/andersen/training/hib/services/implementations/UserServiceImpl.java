package by.andersen.training.hib.services.implementations;

import by.andersen.training.hib.dao.implementations.UserDAOImpl;
import by.andersen.training.hib.dao.interfaces.UserDAO;
import by.andersen.training.hib.models.Auto;
import by.andersen.training.hib.models.User;
import by.andersen.training.hib.services.interfaces.UserService;
import by.andersen.training.hib.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO usersDao = new UserDAOImpl();

    public UserServiceImpl() {
    }

    public User findById(int id) {
        return usersDao.findById(id);
    }

    public void save(User user) {
        usersDao.save(user);
    }

    public void update(User user) {
        usersDao.update(user);
    }

    public void delete(User user) {
        usersDao.delete(user);
    }

    public Auto findAutoById(int id) {
        return usersDao.findAutoById(id);
    }

    public List<User> findAll() {
        return usersDao.findAll();
    }
}
