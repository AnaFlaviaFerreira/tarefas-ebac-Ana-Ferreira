import dao.IProdutoDAO;
import dao.ProdutoDAOMock;
import domain.Produto;
import exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProdutoDAOTest {
    private Produto produto;
    private IProdutoDAO produtoDAO;

    public ProdutoDAOTest() {produtoDAO =  new ProdutoDAOMock();}

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        produto = new Produto();
        produto.setCodigo(133L);
        produto.setNome("Garrafa");
        produto.setDescricao("Garrafa plastica");
        produto.setValor(18.99);
        produtoDAO.cadastrar(produto);
    }

    @Test
    public void pesquisarProduto() {
        Produto prod = produtoDAO.consultar(produto.getCodigo());
        Assert.assertNotNull(prod);
    }

    @Test
    public void salvarProduto() throws TipoChaveNaoEncontradaException {
        Assert.assertTrue(produtoDAO.cadastrar(produto));
    }

    @Test
    public void excluirProduto() {
        produtoDAO.excluir(produto.getCodigo());
    }

    @Test
    public void alterarProduto() throws TipoChaveNaoEncontradaException {
        produto.setNome("Plastico");
        produtoDAO.alterar(produto);
        Assert.assertEquals("Plastico", produto.getNome());
    }
}
