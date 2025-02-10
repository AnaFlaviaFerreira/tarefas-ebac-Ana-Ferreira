import dao.EstoqueDAO;
import dao.IEstoqueDAO;
import dao.IProdutoDAO;
import dao.ProdutoDAO;
import domain.Estoque;
import domain.Produto;
import exceptions.DAOException;
import exceptions.MaisDeUmRegistroException;
import exceptions.TableException;
import exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;

import static org.junit.Assert.*;

public class ProdutoDAOTest {
    private IProdutoDAO produtoDao;
    private IEstoqueDAO estoqueDAO;

    public ProdutoDAOTest() {
        produtoDao = new ProdutoDAO();
        estoqueDAO = new EstoqueDAO();
    }

    @After
    public void end() throws DAOException {
        Collection<Produto> list = produtoDao.buscarTodos();
        list.forEach(prod -> {
            try {
                estoqueDAO.excluir(prod.getId());
                produtoDao.excluir(prod.getCodigo());
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    private Produto criarProduto(String codigo) throws TipoChaveNaoEncontradaException, DAOException {
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setValor(BigDecimal.TEN);
        produto.setStatus(true);
        produtoDao.cadastrar(produto);
        return produto;
    }

    public Boolean criarEstoque(Produto produto, Integer quantidade) throws DAOException, TipoChaveNaoEncontradaException {
        Estoque estoque = new Estoque();
        estoque.setProduto(produto);
        estoque.setQuatidadeEmEstoque(quantidade);
        estoque.setQuantidadeOriginal(quantidade);
        return estoqueDAO.cadastrar(estoque);
    }

    private void excluir(String valor, Long id) throws DAOException {
        this.estoqueDAO.excluir(id);
        this.produtoDao.excluir(valor);
    }

    @Test
    public void pesquisar() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
        Produto produto = criarProduto("A1");
        assertNotNull(produto);
        Produto produtoDB = this.produtoDao.consultar(produto.getCodigo());
        assertNotNull(produtoDB);

        //cadastrar estoque
        Boolean estoqueCad = criarEstoque(produtoDB, 5);
        assertTrue(estoqueCad);

        //Consultar novamente para ver o estoque
        Estoque estoqueDB = this.estoqueDAO.buscarAssociacaoEstoqueProduto(produtoDB.getId());
        assertNotNull(estoqueDB);
        assertEquals(produtoDB.getId(), estoqueDB.getProduto().getId());

        //excluir
        excluir(produtoDB.getCodigo(), produtoDB.getId());
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        Produto produto = criarProduto("A2");
        assertNotNull(produto);
        Produto produtoDB = this.produtoDao.consultar(produto.getCodigo());
        assertNotNull(produtoDB);

        //cadastrar estoque
        Boolean estoqueCad = criarEstoque(produtoDB, 5);
        assertTrue(estoqueCad);

        //Consultar novamente para ver o estoque
        Estoque estoqueDB = this.estoqueDAO.buscarAssociacaoEstoqueProduto(produtoDB.getId());
        assertNotNull(estoqueDB);
        assertEquals(produtoDB.getId(), estoqueDB.getProduto().getId());

        //excluir
        excluir(produtoDB.getCodigo(), produtoDB.getId());
    }

    @Test
    public void excluir() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        Produto produto = criarProduto("A3");
        assertNotNull(produto);

        Produto produtoBD = this.produtoDao.consultar(produto.getCodigo());
        //cadastrar estoque
        Boolean estoqueCad = criarEstoque(produtoBD, 5);
        assertTrue(estoqueCad);

        //Consultar novamente para ver o estoque
        Estoque estoqueDB = this.estoqueDAO.buscarAssociacaoEstoqueProduto(produtoBD.getId());
        assertNotNull(estoqueDB);
        assertEquals(produtoBD.getId(), estoqueDB.getProduto().getId());

        excluir(produto.getCodigo(), produtoBD.getId());

        Produto produtoBD1 = this.produtoDao.consultar(produto.getCodigo());
        assertNull(produtoBD1);
    }

    @Test
    public void alterarProduto() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        Produto produto = criarProduto("A4");
        produto.setNome("Rodrigo Pires");
        produtoDao.alterar(produto);
        Produto produtoBD = this.produtoDao.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        Assert.assertEquals("Rodrigo Pires", produtoBD.getNome());

        //cadastrar estoque
        Boolean estoqueCad = criarEstoque(produtoBD, 5);
        assertTrue(estoqueCad);

        //Consultar novamente para ver o estoque
        Estoque estoqueDB = this.estoqueDAO.buscarAssociacaoEstoqueProduto(produtoBD.getId());
        assertNotNull(estoqueDB);
        assertEquals(produtoBD.getId(), estoqueDB.getProduto().getId());

        excluir(produto.getCodigo(), produtoBD.getId());
        Produto produtoBD1 = this.produtoDao.consultar(produto.getCodigo());
        assertNull(produtoBD1);
    }

    @Test
    public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
        criarProduto("A5");
        criarProduto("A6");
        Collection<Produto> list = produtoDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);

        //cadastrar estoque
        for (Produto prod: list) {
            Boolean estoqueCad = criarEstoque(prod, 5);
            assertTrue(estoqueCad);
        }


        //Consultar novamente para ver o estoque
        Collection<Estoque> listEstoque = this.estoqueDAO.buscarTodos();
        assertNotNull(listEstoque != null);
        assertTrue(listEstoque.size() == 2);

        for (Produto prod : list) {
            excluir(prod.getCodigo(),prod.getId());
        }

        list = produtoDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 0);

    }

    @Test
    public void verificarProdutoAtivo() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        Produto produto = criarProduto("A8");
        assertTrue(produto.getStatus());
    }
}
