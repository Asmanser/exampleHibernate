package by.andersen.training.hib.dao.implementations;

import by.andersen.training.hib.dao.interfaces.UserDAO;
import by.andersen.training.hib.models.Auto;
import by.andersen.training.hib.models.User;
import by.andersen.training.hib.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    public User findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class,id);
    }

    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public Auto findAutoById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class,id);
    }

    public List<User> findAll() {
        return (List<User>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From by.andersen.training.hib.models.User").list();
    }
}
