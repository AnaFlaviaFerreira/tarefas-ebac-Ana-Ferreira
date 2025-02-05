import dao.ClienteDAO;
import dao.IClienteDAO;
import domain.Cliente;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteTest {
    @Test
    public void cadastrarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        //cadastrar
        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Rodrigo Pires");
        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        //Consultar
        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        //Excluir
        Integer qtdDel = dao.excluir(clienteBD);
        assertNotNull(qtdDel);
    }
}
