package by.andersen.training.hibernatecrud.dao.implementations;

import by.andersen.training.hibernatecrud.dao.interfaces.PersonalInformationDAO;
import by.andersen.training.hibernatecrud.models.City;
import by.andersen.training.hibernatecrud.models.PersonalInformation;
import by.andersen.training.hibernatecrud.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PersonalInformationDAOImpl implements PersonalInformationDAO<PersonalInformation,Integer> {

    public List<PersonalInformation> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<PersonalInformation> list = new ArrayList<PersonalInformation>();
        try {
            list = session.createQuery("From by.andersen.training.hibernatecrud.models.PersonalInformation").list();
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return list;
    }

    public boolean add(PersonalInformation personalInformation) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(personalInformation);
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
            Query query = session.createQuery("Delete by.andersen.training.hibernatecrud.models.PersonalInformation as p WHERE p.id = :id");
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

    public boolean update(PersonalInformation personalInformation) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(personalInformation);
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

    public PersonalInformation findById(Integer integer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        PersonalInformation personalInformation = new PersonalInformation();
        try {
            personalInformation = session.get(PersonalInformation.class, integer);
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return personalInformation;
    }
}
