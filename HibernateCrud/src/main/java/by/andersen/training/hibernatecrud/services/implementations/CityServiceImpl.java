package by.andersen.training.hibernatecrud.services.implementations;

import by.andersen.training.hibernatecrud.dao.implementations.CityDAOImpl;
import by.andersen.training.hibernatecrud.dao.interfaces.CityDAO;
import by.andersen.training.hibernatecrud.models.City;
import by.andersen.training.hibernatecrud.services.interfaces.CityService;

import java.util.List;

public class CityServiceImpl implements CityService<City,Integer> {

    private CityDAO<City,Integer> cityDAO = new CityDAOImpl();

    public List<City> getAll() {
        return cityDAO.getAll();
    }

    public boolean add(City city) {
        return cityDAO.add(city);
    }

    public boolean delete(Integer integer) {
        return cityDAO.delete(integer);
    }

    public boolean update(City city) {
        return cityDAO.update(city);
    }

    public City findById(Integer integer) {
        return cityDAO.findById(integer);
    }
}
