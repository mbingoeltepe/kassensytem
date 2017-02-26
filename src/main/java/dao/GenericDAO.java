package dao;


import java.io.Serializable;
import java.util.List;

/**
 * Created by berard on 14.02.17.
 */
public interface GenericDAO<T, ID extends Serializable> {

    public T persistOrMerge (T entity);
    public void delete (T entity);
    public T findById(ID id);
    public List<T> findAll();
}
