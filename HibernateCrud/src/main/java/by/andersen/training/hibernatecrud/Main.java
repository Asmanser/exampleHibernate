package by.andersen.training.hibernatecrud;

import by.andersen.training.hibernatecrud.models.City;
import by.andersen.training.hibernatecrud.models.PersonalInformation;
import by.andersen.training.hibernatecrud.models.Role;
import by.andersen.training.hibernatecrud.models.User;
import by.andersen.training.hibernatecrud.services.dao.implementations.CityServiceImpl;
import by.andersen.training.hibernatecrud.services.dao.implementations.PersonalInformationServiceImpl;
import by.andersen.training.hibernatecrud.services.dao.implementations.RoleServiceImpl;
import by.andersen.training.hibernatecrud.services.dao.implementations.UserServiceImpl;
import by.andersen.training.hibernatecrud.services.dao.interfaces.CityService;
import by.andersen.training.hibernatecrud.services.dao.interfaces.PersonalInformationService;
import by.andersen.training.hibernatecrud.services.dao.interfaces.RoleService;
import by.andersen.training.hibernatecrud.services.dao.interfaces.UserService;
import by.andersen.training.hibernatecrud.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        CityService<City,Integer> cityService = new CityServiceImpl();
        UserService<User,Integer> userService = new UserServiceImpl();
        PersonalInformationService<PersonalInformation, Integer> personalInformationService = new PersonalInformationServiceImpl();
        RoleService<Role,Integer> roleService = new RoleServiceImpl();
        /*cityService.add(new City("Minsk"));
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
        personalInformationService.add(personalInformation);*/
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = userService.findById(4);
        //Hibernate.initialize(user);
        System.out.println(user.getPersonalInformation().getName());
        System.out.println(user.getPersonalInformation().getCity().getCityName());
        System.out.println(user.getRoles().get(0).getRoleName());
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

}
