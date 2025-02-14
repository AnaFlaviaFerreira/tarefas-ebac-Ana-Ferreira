/**
 * 
 */
package main.java.br.com.ana.services;

import main.java.br.com.ana.dao.IProdutoDAO;
import main.java.br.com.ana.domain.Produto;
import main.java.br.com.ana.services.generic.GenericService;

/**
 * @author ana
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
