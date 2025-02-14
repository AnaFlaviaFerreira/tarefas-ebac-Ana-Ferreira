/**
 * 
 */
package main.java.br.com.ana.services;

import main.java.br.com.ana.dao.IClienteDAO;
import main.java.br.com.ana.domain.Cliente;
import main.java.br.com.ana.exceptions.DAOException;
import main.java.br.com.ana.exceptions.MaisDeUmRegistroException;
import main.java.br.com.ana.exceptions.TableException;
import main.java.br.com.ana.exceptions.TipoChaveNaoEncontradaException;
import main.java.br.com.ana.services.generic.GenericService;

/**
 * @author ana
 *
 */
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	//private IClienteDAO clienteDAO;
	
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
		//this.clienteDAO = clienteDAO;
	}

//	@Override
//	public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
//		return clienteDAO.cadastrar(cliente);
//	}

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

//	@Override
//	public void excluir(Long cpf) {
//		clienteDAO.excluir(cpf);
//	}
//
//	@Override
//	public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException{
//		clienteDAO.alterar(cliente);
//	}

}
