package by.andersen.training.hibernatecrud.services.implementations;

import by.andersen.training.hibernatecrud.dao.implementations.UserDAOImpl;
import by.andersen.training.hibernatecrud.dao.interfaces.UserDAO;
import by.andersen.training.hibernatecrud.models.User;
import by.andersen.training.hibernatecrud.services.interfaces.UserService;

import java.util.List;

public class UserServiceImpl implements UserService<User,Integer> {

    private UserDAO<User,Integer> userDAO = new UserDAOImpl();

    public List<User> getAll() {
        return userDAO.getAll();
    }

    public boolean add(User user) {
        return userDAO.add(user);
    }

    public boolean delete(Integer integer) {
        return userDAO.delete(integer);
    }

    public boolean update(User user) {
        return userDAO.update(user);
    }

    public User findById(Integer integer) {
        return userDAO.findById(integer);
    }
}
