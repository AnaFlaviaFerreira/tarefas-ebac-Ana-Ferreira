/**
 * 
 */
package br.com.ana.service;

import br.com.ana.dao.IProdutoDAO;
import br.com.ana.domain.Produto;
import br.com.ana.services.generic.GenericService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * @author ana
 *
 */
@Stateless
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {
	
	private IProdutoDAO produtoDao;

	@Inject
	public ProdutoService(IProdutoDAO produtoDao) {
		super(produtoDao);
		this.produtoDao = produtoDao;
	}

	@Override
	public List<Produto> filtrarProdutos(String query) {
		return produtoDao.filtrarProdutos(query);
	}

}
