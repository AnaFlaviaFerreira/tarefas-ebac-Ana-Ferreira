/**
 * 
 */
package br.com.ana.service;

import br.com.ana.dao.IClienteDAO;
import br.com.ana.domain.Cliente;
import br.com.ana.exceptions.DAOException;
import br.com.ana.exceptions.MaisDeUmRegistroException;
import br.com.ana.exceptions.TableException;
import br.com.ana.services.generic.GenericService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * @author ana
 *
 */
@Stateless
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	private IClienteDAO clienteDAO;
	
	@Inject
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
		this.clienteDAO = clienteDAO;
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cliente> filtrarClientes(String query) {
		return clienteDAO.filtrarClientes(query);
	}

}
