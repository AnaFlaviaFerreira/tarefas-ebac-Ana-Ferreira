/**
 * 
 */
package main.java.br.com.ana.dao.jpa;

import main.java.br.com.ana.dao.generic.jpa.GenericJpaDB3DAO;
import main.java.br.com.ana.domain.jpa.ClienteJpa2;

public class ClienteJpaDB3DAO extends GenericJpaDB3DAO<ClienteJpa2, Long> implements IClienteJpaDAO<ClienteJpa2> {

	public ClienteJpaDB3DAO() {
		super(ClienteJpa2.class);
	}

}
