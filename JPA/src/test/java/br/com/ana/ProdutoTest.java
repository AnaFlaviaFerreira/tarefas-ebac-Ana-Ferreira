package test.java.br.com.ana;

import main.java.br.com.ana.dao.IProdutoDao;
import main.java.br.com.ana.dao.ProdutoDao;
import main.java.br.com.ana.domain.Produto;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {
    private IProdutoDao produtoDao;

    public ProdutoTest() {

        produtoDao = new ProdutoDao();
    }

    @After
    public void end() {
        List<Produto> list = produtoDao.buscarTodos();
        list.forEach(produto -> produtoDao.excluir(produto));
    }

    private Produto criarProduto(String codigo) {
        Produto prod = new Produto();
        prod.setCodigo(codigo);
        prod.setNome("Produto 1");
        prod.setStatus("ATIVA");
        prod.setValor(2000d);
        prod = produtoDao.cadastrar(prod);
        return prod;
    }

    @Test
    public void cadastrar() {
        Produto prod = criarProduto("A1");

        assertNotNull(prod);
        assertNotNull(prod.getId());
    }

    @Test
    public void consultar() {
        Produto prod = criarProduto("A2");
        Produto prodDB = produtoDao.consultar(prod.getId());
        assertNotNull(prodDB);
        assertEquals(prodDB.getId(), prod.getId());
    }

    @Test
    public void buscarTodos() {
        criarProduto("A1");
        criarProduto("A2");
        List list = produtoDao.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());
    }

    @Test
    public void excluir() {
        Produto prod = criarProduto("A1");
        produtoDao.excluir(prod);
        Produto prodDB = produtoDao.consultar(prod.getId());
        assertNull(prodDB);
    }

    @Test
    public void alterar() {
        Produto prod = criarProduto("A1");
        prod.setStatus("INATIVO");
        Produto prodUpdate = produtoDao.alterar(prod);
        assertNotNull(prodUpdate);
        assertEquals("INATIVO",prodUpdate.getStatus());
    }
}
