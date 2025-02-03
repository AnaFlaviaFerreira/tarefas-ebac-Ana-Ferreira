package services;

import dao.IClienteDAO;
import domain.Cliente;
import exception.TipoChaveNaoEncontradaException;
import services.generics.GenericService;

public class ClienteService extends GenericService<Cliente> implements IClienteService {
    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
    }
}
