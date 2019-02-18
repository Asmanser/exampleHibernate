package by.andersen.training.hibernatecrud.services.implementations;

import by.andersen.training.hibernatecrud.dao.implementations.RoleDAOImpl;
import by.andersen.training.hibernatecrud.dao.interfaces.RoleDAO;
import by.andersen.training.hibernatecrud.models.Role;
import by.andersen.training.hibernatecrud.services.interfaces.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService<Role,Integer> {

    private RoleDAO<Role,Integer> roleDAO = new RoleDAOImpl();

    public List<Role> getAll() {
        return roleDAO.getAll();
    }

    public boolean add(Role role) {
        return roleDAO.add(role);
    }

    public boolean delete(Integer integer) {
        return roleDAO.delete(integer);
    }

    public boolean update(Role role) {
        return roleDAO.update(role);
    }

    public Role findById(Integer integer) {
        return roleDAO.findById(integer);
    }
}
