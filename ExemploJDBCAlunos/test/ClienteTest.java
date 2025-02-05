import dao.ClienteDAO;
import dao.IClienteDAO;
import domain.Cliente;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void atualizarTest() throws Exception {
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

        //Atualizar
        clienteBD.setNome("Ana Flávia");
        Integer qtdAtualizar = dao.alterar(clienteBD);
        assertTrue(qtdAtualizar == 1);

        //Excluir
        Integer qtdDel = dao.excluir(clienteBD);
        assertNotNull(qtdDel);
    }

    @Test
    public  void buscarTodos() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        //cadastrar 1
        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Rodrigo Pires");
        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);


        //cadastrar 2
        Cliente cliente2 = new Cliente();
        cliente2.setCodigo("02");
        cliente2.setNome("Ana Flávia");
        Integer qtd2 = dao.cadastrar(cliente2);
        assertTrue(qtd2 == 1);

        //buscar
        List<Cliente> list = dao.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        //excluirTodos
        Integer qtdDel = dao.excluirTodos();
        assertNotNull(qtdDel);
    }
}
