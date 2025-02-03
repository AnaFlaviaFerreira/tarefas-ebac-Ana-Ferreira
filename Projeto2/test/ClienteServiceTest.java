import dao.ClienteDAOMock;
import dao.IClienteDAO;
import domain.Cliente;
import exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.ClienteService;
import services.IClienteService;

public class ClienteServiceTest {
    private IClienteService clienteService;
    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDAOMock();
        clienteService = new ClienteService(dao);
    }


    @Before
    public void init()  {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Rodrigo");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
    }


    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
       Boolean retorno = clienteService.salvar(cliente);
       Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Ana");
        clienteService.alterar(cliente);
        Assert.assertEquals("Ana",cliente.getNome());
    }
}
