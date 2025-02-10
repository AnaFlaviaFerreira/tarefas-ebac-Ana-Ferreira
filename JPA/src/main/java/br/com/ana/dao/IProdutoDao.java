package main.java.br.com.ana.dao;

import main.java.br.com.ana.domain.Produto;

import java.util.Collection;
import java.util.List;

public interface IProdutoDao {
    Produto cadastrar(Produto prod);

    Produto consultar(Long codigo);

    List buscarTodos();

    void excluir(Produto prod);

    Produto alterar(Produto prod);

}
