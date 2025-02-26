/**
 * 
 */
package br.com.ana.service;

import br.com.ana.domain.Cliente;
import br.com.ana.exceptions.DAOException;
import br.com.ana.services.generic.IGenericService;

import java.util.List;

/**
 * @author ana
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

	List<Cliente> filtrarClientes(String query);

}
