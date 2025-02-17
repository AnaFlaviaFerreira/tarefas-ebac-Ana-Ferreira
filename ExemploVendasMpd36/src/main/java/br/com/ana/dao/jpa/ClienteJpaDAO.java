/**
 * 
 */
package main.java.br.com.ana.dao.jpa;

import main.java.br.com.ana.dao.generic.jpa.GenericJpaDB1DAO;
import main.java.br.com.ana.domain.jpa.ClienteJpa;


public class ClienteJpaDAO extends GenericJpaDB1DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}

}
