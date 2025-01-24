package generic;

import domain.Persistent;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class GenericDAO<T extends Persistent> implements IGenericDAO<T> {
    protected Map<Class, Map<Long, T>> map;
    public abstract Class<T> getTypeClass();
    public abstract void updateData(T entity, T entityRegistered);

    public GenericDAO() {
        if (this.map == null) {
            this.map = new HashMap<>();
        }
    }

    @Override
    public Boolean insert(T entity) {
        Map<Long, T> mapInterno = this.map.get(getTypeClass());
        if (mapInterno.containsKey(entity.getId())) {
            return false;
        }
        mapInterno.put(entity.getId(),entity);
        return true;
    }

    @Override
    public void delete(Long valor) {
        Map<Long, T> mapInterno = this.map.get(getTypeClass());
        T objetoCadastrado = mapInterno.get(valor);
        if (objetoCadastrado != null) {
            mapInterno.remove(valor, objetoCadastrado);
        }
    }

    @Override
    public void update(T entity) {
        Map<Long, T> mapInterno = this.map.get(getTypeClass());
        T objetoCadastrado = mapInterno.get(entity.getId());
        if (objetoCadastrado != null) {
            updateData(entity,objetoCadastrado);
        }
    }

    @Override
    public T search(Long valor) {
        Map<Long, T> mapInterno = this.map.get(getTypeClass());
        return mapInterno.get(valor);
    }

    @Override
    public Collection<T> searchAll() {
        Map<Long, T> mapInterno = this.map.get(getTypeClass());
        return mapInterno.values();
    }
}
