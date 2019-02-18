package by.andersen.training.hibernatecrud;

import by.andersen.training.hibernatecrud.dao.implementations.CityDAOImpl;
import by.andersen.training.hibernatecrud.dao.interfaces.CityDAO;
import by.andersen.training.hibernatecrud.models.City;
import by.andersen.training.hibernatecrud.models.User;
import by.andersen.training.hibernatecrud.utils.HibernateSessionFactoryUtil;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        CityDAO<City,Integer> cityDAO = new CityDAOImpl();
        /*cityDAO.add(new City("Minsk"));
        cityDAO.add(new City("Gomel"));
        cityDAO.add(new City("Bobruisk"));
        List<City> cities = cityDAO.getAll();
        for(City city:cities) {
            System.out.println(city);
        }*/
        /*List<City> cities = cityDAO.getAll();
        City city = cities.get(0);
        city.setCityName("Gomel");
        cityDAO.update(city);*/
        City byId = cityDAO.findById(2);
        System.out.println(byId);
        sessionFactory.close();
    }

}
