package dao;

import domain.Cliente;

import java.util.List;

public interface IClienteDAO {
    public Integer cadastrar(Cliente cliente) throws Exception;

    public Cliente consultar(String codigo) throws Exception;

    public Integer excluir(Cliente clienteBD) throws Exception;

    public List<Cliente> buscarTodos() throws Exception;

    public Integer alterar(Cliente cliente) throws Exception;

    public Integer excluirTodos() throws Exception;
}
