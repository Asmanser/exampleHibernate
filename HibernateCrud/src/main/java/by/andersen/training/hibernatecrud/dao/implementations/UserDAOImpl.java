package by.andersen.training.hibernatecrud.dao.implementations;

import by.andersen.training.hibernatecrud.dao.interfaces.UserDAO;
import by.andersen.training.hibernatecrud.models.City;
import by.andersen.training.hibernatecrud.models.User;
import by.andersen.training.hibernatecrud.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO<User,Integer> {

    public List<User> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = new ArrayList<User>();
        try {
            list = session.createQuery("From by.andersen.training.hibernatecrud.models.User").list();
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return list;
    }

    public boolean add(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(user);
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            session.close();
            return false;
        }
        transaction.commit();
        session.close();
        return true;
    }

    public boolean delete(Integer integer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("Delete by.andersen.training.hibernatecrud.models.User as u WHERE u.id = :id");
            query.setParameter("id",integer);
            query.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            session.close();
            return false;
        }
        transaction.commit();
        session.close();
        return true;
    }

    public boolean update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(user);
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            session.close();
            return false;
        }
        transaction.commit();
        session.close();
        return true;
    }

    public User findById(Integer integer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User user = new User();
        try {
            user = session.get(User.class, integer);
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return user;
    }
}
