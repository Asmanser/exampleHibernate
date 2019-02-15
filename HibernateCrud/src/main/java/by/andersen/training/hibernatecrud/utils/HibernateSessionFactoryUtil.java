package by.andersen.training.hibernatecrud.utils;

import by.andersen.training.hibernatecrud.models.City;
import by.andersen.training.hibernatecrud.models.PersonalInformation;
import by.andersen.training.hibernatecrud.models.Role;
import by.andersen.training.hibernatecrud.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(City.class);
                configuration.addAnnotatedClass(PersonalInformation.class);
                configuration.addAnnotatedClass(Role.class);
                configuration.addAnnotatedClass(User.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
