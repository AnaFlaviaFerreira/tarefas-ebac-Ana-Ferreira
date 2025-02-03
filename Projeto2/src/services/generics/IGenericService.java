package services.generics;

import domain.Cliente;
import domain.Persistente;
import exception.TipoChaveNaoEncontradaException;

public interface IGenericService<T extends Persistente> {
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;

    public T consultar(Long valor);

    public void excluir(Long valor);

    public void alterar(T entity) throws TipoChaveNaoEncontradaException;
}
