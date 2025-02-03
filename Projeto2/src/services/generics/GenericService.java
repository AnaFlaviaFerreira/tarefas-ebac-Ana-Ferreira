package services.generics;

import dao.generics.IGenericDAO;
import domain.Persistente;
import exception.TipoChaveNaoEncontradaException;

public abstract class GenericService<T extends Persistente> implements IGenericService<T>{
    protected IGenericDAO<T> dao;

    public GenericService(IGenericDAO<T> dao) {
        this.dao = dao;
    }

    @Override
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException {
        return this.dao.cadastrar(entity);
    }

    @Override
    public T consultar(Long valor) {
        return this.dao.consultar(valor);
    }

    @Override
    public void excluir(Long valor) {
        this.dao.excluir(valor);
    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException {
        this.dao.alterar(entity);
    }
}
