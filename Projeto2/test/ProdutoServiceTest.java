import dao.IProdutoDAO;
import dao.ProdutoDAOMock;
import domain.Produto;
import exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.IProdutoService;
import services.ProdutoService;

public class ProdutoServiceTest {
    private IProdutoService produtoService;
    private Produto produto;

    public ProdutoServiceTest() {
        IProdutoDAO dao = new ProdutoDAOMock();
        produtoService = new ProdutoService(dao);
    }

    @Before
    public void init() {
        produto = new Produto();
        produto.setCodigo(133L);
        produto.setNome("Garrafa");
        produto.setDescricao("Garrafa plastica");
        produto.setValor(18.99);
    }

    @Test
    public void pesquisarProduto() {
        Produto prod = produtoService.consultar(produto.getCodigo());
        Assert.assertNotNull(prod);
    }

    @Test
    public void salvarProduto() throws TipoChaveNaoEncontradaException {
        Assert.assertTrue(produtoService.cadastrar(produto));
    }

    @Test
    public void excluirProduto() {
        produtoService.excluir(produto.getCodigo());
    }

    @Test
    public void alterarProduto() throws TipoChaveNaoEncontradaException {
        produto.setNome("Plastico");
        produtoService.alterar(produto);
        Assert.assertEquals("Plastico", produto.getNome());
    }
}
