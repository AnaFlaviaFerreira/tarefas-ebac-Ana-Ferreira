/**
 * 
 */
package br.com.ana.dao;

import br.com.ana.dao.generic.IGenericDAO;
import br.com.ana.domain.Produto;

import java.util.List;

/**
 * @author ana
 *
 */
public interface IProdutoDAO extends IGenericDAO<Produto, String>{

	List<Produto> filtrarProdutos(String query);

}
