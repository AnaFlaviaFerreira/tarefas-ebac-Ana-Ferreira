/**
 * 
 */
package br.com.ana.dao;

import br.com.ana.dao.generic.IGenericDAO;
import br.com.ana.domain.Cliente;

import java.util.List;

/**
 * @author ana
 *
 */
public interface IClienteDAO extends IGenericDAO<Cliente, Long>{

	List<Cliente> filtrarClientes(String query);

}
