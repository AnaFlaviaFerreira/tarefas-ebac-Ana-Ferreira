package main.java.br.com.ana.dao;

import main.java.br.com.ana.domain.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.List;

public class ProdutoDao implements IProdutoDao {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Override
    public Produto cadastrar(Produto prod) {
        init();
        entityManager.getTransaction().begin();
        entityManager.persist(prod);
        entityManager.getTransaction().commit();
        close();
        return prod;
    }

    @Override
    public Produto consultar(Long id) {
        init();
        Produto prod = entityManager.find(Produto.class, id);
        close();
        return prod;
    }

    @Override
    public List buscarTodos() {
        init();
        List prods = entityManager.createQuery(" FROM " + Produto.class.getName()).getResultList();
        close();
        return prods;
    }

    @Override
    public void excluir(Produto prod) {
        init();
        entityManager.getTransaction().begin();
        prod = entityManager.merge(prod);
        entityManager.remove(prod);
        entityManager.getTransaction().commit();
        close();
    }

    @Override
    public Produto alterar(Produto prod) {
        init();
        entityManager.getTransaction().begin();
        entityManager.merge(prod);
        entityManager.getTransaction().commit();
        close();
        return prod;
    }

    private void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("TarefaJPA");
        entityManager = entityManagerFactory.createEntityManager();
    }

    private  void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
