package by.andersen.training.hibernatecrud.dao.interfaces;

import java.util.List;

public interface CRUD<T,K> {

    public List<T> getAll();

    public boolean add(T t);

    public boolean delete(K k);

    public boolean update(T t);

    public T findById(K k);

}
