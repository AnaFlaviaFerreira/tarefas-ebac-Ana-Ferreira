package main.java.br.com.ana.dao.jpa;

import main.java.br.com.ana.dao.generic.jpa.GenericJpaDAO;
import main.java.br.com.ana.domain.jpa.ClienteJPA;

public class ClienteJpaDAO extends GenericJpaDAO<ClienteJPA, Long> implements IClienteJpaDAO{
    public ClienteJpaDAO() {
        super(ClienteJPA.class);
    }
}
