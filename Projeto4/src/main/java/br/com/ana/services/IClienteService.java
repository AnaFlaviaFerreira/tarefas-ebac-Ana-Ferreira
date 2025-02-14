/**
 * 
 */
package main.java.br.com.ana.services;

import main.java.br.com.ana.domain.Cliente;
import main.java.br.com.ana.exceptions.DAOException;
import main.java.br.com.ana.exceptions.TipoChaveNaoEncontradaException;
import main.java.br.com.ana.services.generic.IGenericService;

/**
 * @author ana
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
