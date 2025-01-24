package dao;

import domain.Honda;
import domain.OtherBrand;
import domain.Persistent;
import generic.GenericDAO;

import java.util.HashMap;

public class OtherBrandDAO   extends GenericDAO<OtherBrand> implements IOtherBrandDAO {
    @Override
    public Class<OtherBrand> getTypeClass() {
        return OtherBrand.class;
    }

    @Override
    public void updateData(OtherBrand entity, OtherBrand entityRegistered) {
        entityRegistered.setBrandName(entity.getBrandName());
        entityRegistered.setCountryOrigin(entity.getCountryOrigin());

        entityRegistered.setColor(entity.getColor());
        entityRegistered.setType(entity.getType());
        entityRegistered.setModel(entity.getModel());
    }

    public OtherBrand createObjets(String[] data) {
        return new OtherBrand(Long.parseLong(data[0].trim()),data[1], data[2], data[3], data[4], data[5]);
    }

    @Override
    public String toString(OtherBrand entity) {
        return "Honda: {" +
                "Código:" + entity.getId() +
                ", Cor:" + entity.getColor() +
                ", Tipo:" + entity.getType() +
                ", Modelo:" + entity.getModel() +
                ", Marca:" + entity.getBrandName() +
                ", Origem:" + entity.getCountryOrigin() +
                "} ";
    }

    public OtherBrandDAO() {
        if (this.map.get(getTypeClass()) == null) {
            this.map.put(getTypeClass(),new HashMap<>());
        }
    }

}
