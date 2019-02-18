package by.andersen.training.hibernatecrud;

import by.andersen.training.hibernatecrud.dao.implementations.CityDAOImpl;
import by.andersen.training.hibernatecrud.dao.interfaces.CityDAO;
import by.andersen.training.hibernatecrud.models.City;
import by.andersen.training.hibernatecrud.models.PersonalInformation;
import by.andersen.training.hibernatecrud.models.Role;
import by.andersen.training.hibernatecrud.models.User;
import by.andersen.training.hibernatecrud.services.implementations.CityServiceImpl;
import by.andersen.training.hibernatecrud.services.implementations.PersonalInformationServiceImpl;
import by.andersen.training.hibernatecrud.services.implementations.RoleServiceImpl;
import by.andersen.training.hibernatecrud.services.implementations.UserServiceImpl;
import by.andersen.training.hibernatecrud.services.interfaces.CityService;
import by.andersen.training.hibernatecrud.services.interfaces.PersonalInformationService;
import by.andersen.training.hibernatecrud.services.interfaces.RoleService;
import by.andersen.training.hibernatecrud.services.interfaces.UserService;
import by.andersen.training.hibernatecrud.utils.HibernateSessionFactoryUtil;
import com.sun.javafx.image.IntPixelGetter;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        CityService<City,Integer> cityService = new CityServiceImpl();
        UserService<User,Integer> userService = new UserServiceImpl();
        PersonalInformationService<PersonalInformation, Integer> personalInformationService = new PersonalInformationServiceImpl();
        RoleService<Role,Integer> roleService = new RoleServiceImpl();
        cityService.add(new City("Minsk"));
        cityService.add(new City("Bobruisk"));
        User user = new User();
        user.setLogin("user");
        user.setPassword("user");
        Role role = new Role("User");
        List<Role> roles = new ArrayList<Role>();
        roles.add(role);
        user.setRoles(roles);
        PersonalInformation personalInformation = new PersonalInformation("Sasha","Kazimov","Ruslanovich",(byte)20,"bybirmybir@gmail.com");
        personalInformation.setCity(new City("Gomel"));
        personalInformation.setUser(user);
        user.setPersonalInformation(personalInformation);
        personalInformationService.add(personalInformation);
        sessionFactory.close();
    }

}
