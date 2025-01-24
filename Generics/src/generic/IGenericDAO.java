package generic;

import domain.Honda;
import domain.Persistent;

import java.util.Collection;

public interface IGenericDAO  <T extends Persistent> {
    public Boolean insert(T entity);

    public void delete(Long valor);

    public void update(T entity);

    public T search(Long valor);

    public Collection<T> searchAll();

    public T createObjets(String[] data);
    public String toString(T entity);
}
