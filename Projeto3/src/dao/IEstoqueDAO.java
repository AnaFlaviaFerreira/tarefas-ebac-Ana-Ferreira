package dao;

import dao.generic.IGenericDAO;
import domain.Estoque;
import exceptions.DAOException;

public interface IEstoqueDAO extends IGenericDAO<Estoque, Long> {
    public Estoque buscarAssociacaoEstoqueProduto(Long idProduto) throws DAOException;
}
