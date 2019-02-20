package by.andersen.training.hibernatecrud.dao.implementations;

import by.andersen.training.hibernatecrud.dao.interfaces.CityDAO;
import by.andersen.training.hibernatecrud.models.City;
import by.andersen.training.hibernatecrud.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CityDAOImpl implements CityDAO<City, Integer> {

    public List<City> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<City> list = new ArrayList<City>();
        try {
            list = session.createQuery("From by.andersen.training.hibernatecrud.models.City").list();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return list;
    }

    public boolean add(City city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(city);
        } catch (Exception e) {
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
            Query query = session.createQuery("Delete by.andersen.training.hibernatecrud.models.City as c WHERE c.id = :id");
            query.setParameter("id", integer);
            query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            session.close();
            return false;
        }
        transaction.commit();
        session.close();
        return true;
    }

    public boolean update(City city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(city);
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            session.close();
            return false;
        }
        transaction.commit();
        session.close();
        return true;
    }

    public City findById(Integer integer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        City city = new City();
        try {
            city = session.get(City.class, integer);
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return city;
    }
}
