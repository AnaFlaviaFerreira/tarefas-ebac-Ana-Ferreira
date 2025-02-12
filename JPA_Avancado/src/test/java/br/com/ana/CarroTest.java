package test.java.br.com.ana;

import main.java.br.com.ana.dao.CarroDao;
import main.java.br.com.ana.dao.ICarroDao;
import main.java.br.com.ana.dao.IMarcaDao;
import main.java.br.com.ana.dao.MarcaDao;
import main.java.br.com.ana.domain.Acessorio;
import main.java.br.com.ana.domain.Carro;
import main.java.br.com.ana.domain.Marca;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CarroTest {
    private IMarcaDao marcaDao;
    private ICarroDao carroDao;

    public CarroTest() {
        marcaDao = new MarcaDao();
        carroDao = new CarroDao();
    }

    private Marca criarMarca(String codigo) {
        Marca marca = new Marca();
        marca.setCodigo(codigo);
        marca.setNome("Nissan");
        return marcaDao.cadastrar(marca);
    }

    private Acessorio criarAcessorio(String codigo) {
        Acessorio acessorio = new Acessorio();
        acessorio.setCodigo(codigo);
        acessorio.setNome("Câmera");
        return acessorio;
    }

    @Test
    public void cadastrar() {
        Marca marca = criarMarca("A1");
        Acessorio acessorio = criarAcessorio("A1");
        Acessorio acessorio2 = criarAcessorio("A2");

        Carro carro = new Carro();
        carro.setCodigo("A1");
        carro.setModelo("Kicks");
        carro.setCor("Vermelho");
        carro.setTipo("SUV");
        carro.setMarca(marca);
        carro.addAcessorio(acessorio);
        carro.addAcessorio(acessorio2);
        carro = carroDao.cadastrar(carro);

        assertNotNull(carro);
        assertNotNull(carro.getId());
    }
}
