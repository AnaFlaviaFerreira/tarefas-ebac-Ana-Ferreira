/**
 * 
 */
package br.com.ana.service;

import br.com.ana.dao.IVendaDAO;
import br.com.ana.domain.Venda;
import br.com.ana.domain.Venda.Status;
import br.com.ana.exceptions.DAOException;
import br.com.ana.exceptions.TipoChaveNaoEncontradaException;
import br.com.ana.services.generic.GenericService;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author ana
 *
 */
@Stateless
public class VendaService extends GenericService<Venda, Long> implements IVendaService {

	IVendaDAO dao;
	
	@Inject
	public VendaService(IVendaDAO dao) {
		super(dao);
		this.dao = dao;
	}

	@Override
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		venda.setStatus(Status.CONCLUIDA);
		dao.finalizarVenda(venda);
	}

	@Override
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		venda.setStatus(Status.CANCELADA);
		dao.cancelarVenda(venda);
	}

	@Override
	public Venda consultarComCollection(Long id) {
		return dao.consultarComCollection(id);
	}

	@Override
	public Venda cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException {
		entity.setStatus(Status.INICIADA);
		return super.cadastrar(entity);
	}
	
	

}
