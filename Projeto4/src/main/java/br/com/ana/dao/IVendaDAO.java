/**
 * 
 */
package main.java.br.com.ana.dao;

import main.java.br.com.ana.dao.generic.IGenericDAO;
import main.java.br.com.ana.domain.Venda;
import main.java.br.com.ana.exceptions.DAOException;
import main.java.br.com.ana.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author ana
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
