package dao;

import dao.generic.IGenericDAO;
import domain.Estoque;
import domain.Produto;
import exceptions.DAOException;
import exceptions.TipoChaveNaoEncontradaException;

public interface IProdutoDAO  extends IGenericDAO<Produto, String> {
}
