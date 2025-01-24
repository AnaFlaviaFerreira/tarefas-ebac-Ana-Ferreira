package dao;

import domain.Honda;
import domain.Persistent;
import generic.GenericDAO;

import java.util.HashMap;
import java.util.Map;

public class HondaDAO  extends GenericDAO<Honda> implements IHondaDAO {
    @Override
    public Class<Honda> getTypeClass() {
        return Honda.class;
    }

    @Override
    public void updateData(Honda entity, Honda entityRegistered) {
        entityRegistered.setColor(entity.getColor());
        entityRegistered.setType(entity.getType());
        entityRegistered.setModel(entity.getModel());
    }

    @Override
    public String toString(Honda entity) {
        return "Honda: {" +
                "Código:" + entity.getId() +
                ", Cor:" + entity.getColor() +
                ", Tipo:" + entity.getType() +
                ", Modelo:" + entity.getModel() +
                "} ";
    }

    @Override
    public Honda createObjets(String[] data) {
        return new Honda(Long.parseLong(data[0].trim()),data[1], data[2], data[3]);
    }

    public HondaDAO() {
        if (this.map.get(getTypeClass()) == null) {
            this.map.put(getTypeClass(),new HashMap<>());
        }
    }
}
