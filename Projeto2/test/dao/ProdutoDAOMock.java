package dao;

import domain.Produto;
import exception.TipoChaveNaoEncontradaException;

import java.util.Collection;
import java.util.List;

public class ProdutoDAOMock implements IProdutoDAO {
    @Override
    public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Produto consultar(Long valor) {
        Produto prod = new Produto();
        prod.setCodigo(valor);
        return prod;
    }

    @Override
    public Collection<Produto> buscarTodos() {
        return List.of();
    }
}
