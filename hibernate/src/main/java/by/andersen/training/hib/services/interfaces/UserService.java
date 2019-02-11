package by.andersen.training.hib.services.interfaces;

import by.andersen.training.hib.models.Auto;
import by.andersen.training.hib.models.User;

import java.util.List;

public interface UserService {

    public User findById(int id);

    public void save(User user);

    public void update(User user);

    public void delete(User user);

    public Auto findAutoById(int id);

    public List<User> findAll();

}
