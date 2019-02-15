package by.andersen.training.hibernatecrud;

import by.andersen.training.hibernatecrud.utils.HibernateSessionFactoryUtil;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    }

}
