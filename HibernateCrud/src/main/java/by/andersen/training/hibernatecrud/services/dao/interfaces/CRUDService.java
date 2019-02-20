package by.andersen.training.hibernatecrud.services.dao.interfaces;

import java.util.List;

public interface CRUDService<T,K> {

    public List<T> getAll();

    public boolean add(T t);

    public boolean delete(K k);

    public boolean update(T t);

    public T findById(K k);

}
