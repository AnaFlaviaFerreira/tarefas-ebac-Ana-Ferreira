import dao.IProdutoDAO;
import dao.ProdutoDAO;
import domain.Produto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ProdutoTest {

    @Test
    public void cadastrarTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        //cadastrar
        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Garrafa");
        produto.setDescricao("Termica");
        produto.setPreco(10.99);
        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        //consultar
        Produto produtoDB = dao.consultar(produto.getCodigo());
        assertNotNull(produtoDB);
        assertNotNull(produtoDB.getId());
        assertEquals(produtoDB.getCodigo(), produtoDB.getCodigo());
        assertEquals(produtoDB.getNome(), produtoDB.getNome());

        //excluir
        Integer qtdDel = dao.excluir(produtoDB);
        assertNotNull(qtdDel);
    }

    @Test
    public void atualizarTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        //cadastrar
        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Garrafa");
        produto.setDescricao("Termica");
        produto.setPreco(10.99);
        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        //consultar
        Produto produtoDB = dao.consultar(produto.getCodigo());
        assertNotNull(produtoDB);
        assertNotNull(produtoDB.getId());
        assertEquals(produtoDB.getCodigo(), produtoDB.getCodigo());
        assertEquals(produtoDB.getNome(), produtoDB.getNome());

        //atualizar
        produtoDB.setPreco(17.99);
        Integer qtdAtualizar = dao.alterar(produtoDB);
        assertTrue(qtdAtualizar == 1);

        //excluir
        Integer qtdDel = dao.excluir(produtoDB);
        assertNotNull(qtdDel);
    }

    @Test
    public void buscarTodos() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        //cadastrar 1
        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Garrafa");
        produto.setDescricao("Termica");
        produto.setPreco(10.99);
        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        //cadastrar 2
        Produto produto1 = new Produto();
        produto1.setCodigo("02");
        produto1.setNome("Garrafas");
        produto1.setDescricao("Termicas");
        produto1.setPreco(20.99);
        Integer qtd2 = dao.cadastrar(produto1);
        assertTrue(qtd2 == 1);

        //consultar
        List<Produto> list = dao.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        //excluir
        Integer qtdDel = dao.excluirTodos();
        assertNotNull(qtdDel);
    }
}
