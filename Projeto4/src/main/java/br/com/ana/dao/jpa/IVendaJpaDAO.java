package main.java.br.com.ana.dao.jpa;

import main.java.br.com.ana.dao.generic.jpa.IGenericJpaDAO;
import main.java.br.com.ana.domain.jpa.VendaJPA;
import main.java.br.com.ana.exceptions.DAOException;
import main.java.br.com.ana.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaJpaDAO extends IGenericJpaDAO<VendaJPA, Long> {
    public void finalizarVenda(VendaJPA venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(VendaJPA venda) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Usando este método para evitar a exception org.hibernate.LazyInitializationException
     * Ele busca todos os dados de objetos que tenham colletion pois a mesma por default é lazy
     * Mas você pode configurar a propriedade da collection como fetch = FetchType.EAGER na anotação @OneToMany e usar o consultar genérico normal
     *
     * OBS: Não é uma boa prática utiliar FetchType.EAGER pois ele sempre irá trazer todos os objetos da collection
     * mesmo sem precisar utilizar.
     *
     *
     * @see VendaJPA produtos
     *
     * @param id
     * @return
     */
    public VendaJPA consultarComCollection(Long id);
}
