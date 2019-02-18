package by.andersen.training.hibernatecrud.dao.implementations;

import by.andersen.training.hibernatecrud.dao.interfaces.RoleDAO;
import by.andersen.training.hibernatecrud.models.City;
import by.andersen.training.hibernatecrud.models.Role;
import by.andersen.training.hibernatecrud.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class RoleDAOImpl implements RoleDAO<Role,Integer> {

    public List<Role> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Role> roles = new ArrayList<Role>();
        try {
            roles = session.createQuery("From by.andersen.training.hibernatecrud.models.Role").list();
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return roles;
    }

    public boolean add(Role role) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(role);
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
            Query query = session.createQuery("Delete by.andersen.training.hibernatecrud.models.Role as r WHERE r.id = :id");
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

    public boolean update(Role role) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(role);
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

    public Role findById(Integer integer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Role role = new Role();
        try {
            role = session.get(Role.class, integer);
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return role;
    }
}
