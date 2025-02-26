/**
 * 
 */
package br.com.ana.service;

import br.com.ana.domain.Produto;
import br.com.ana.services.generic.IGenericService;

import java.util.List;

/**
 * @author ana
 *
 */
public interface IProdutoService extends IGenericService<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}
